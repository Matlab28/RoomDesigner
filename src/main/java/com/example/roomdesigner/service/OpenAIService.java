package com.example.roomdesigner.service;

import com.example.roomdesigner.dto.openAI.Message;
import com.example.roomdesigner.dto.openAI.Root;
import com.example.roomdesigner.dto.request.OpenAIRequest;
import com.example.roomdesigner.dto.response.QuestionResponseDTO;
import com.example.roomdesigner.entity.QuestionEntity;
import com.example.roomdesigner.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.buffer.DefaultDataBuffer;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import java.io.IOException;
import java.util.*;

@Service
@Slf4j
public class OpenAIService {
    private final WebClient webClient;
    private final ModelMapper modelMapper;
    private final QuestionRepository repository;

    @Value("${openai.api.key}")
    private String API_KEY;

    @Value("${openai.api.model}")
    private String API_MODEL;

    @Value("${openai.api.url}")
    private String API_URL;

    public OpenAIService(ModelMapper modelMapper, QuestionRepository repository) {
        this.modelMapper = modelMapper;
        this.repository = repository;
        this.webClient = WebClient.builder()
                .baseUrl(API_URL)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + API_KEY)
                .build();
    }

    public String processRoomImage(MultipartFile file, String prompt) throws IOException {
        byte[] imageBytes = file.getBytes();
        DefaultDataBuffer buffer = new DefaultDataBufferFactory().wrap(imageBytes);

        MultipartBodyBuilder bodyBuilder = new MultipartBodyBuilder();
        bodyBuilder.part("image", buffer)
                .header("Content-Disposition", "form-data; name=image; filename=" + file.getOriginalFilename());

        bodyBuilder.part("prompt", prompt);
        bodyBuilder.part("model", "dall-e-2");

        Map response = webClient.post()
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromMultipartData(bodyBuilder.build()))
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        if (response != null && response.containsKey("data")) {
            List<Map<String, Object>> data = (List<Map<String, Object>>) response.get("data");
            if (!data.isEmpty() && data.get(0).containsKey("url")) {
                return (String) data.get(0).get("url");
            }
        }
        throw new RuntimeException("Failed to process the image.");
    }

    public QuestionResponseDTO handleUserQuestion(QuestionResponseDTO dto) {
        QuestionEntity entity = modelMapper.map(dto, QuestionEntity.class);
        Optional<QuestionEntity> existingUser = repository.findById(dto.getId());
        if (existingUser.isPresent()) {
            entity = existingUser.get();
        } else {
            dto.setId(entity.getId());
            log.info("\"{}\" ID of user.", dto.getId());
            repository.save(entity);
        }

        List<Message> messages = new ArrayList<>();

        Message message = new Message();
        message.setRole("user");
        message.setContent(dto.getOpenAIResponse());
        messages.add(message);

        OpenAIRequest requestBody = new OpenAIRequest();
        requestBody.setModel(API_MODEL);
        requestBody.setMessages(messages);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + API_KEY);
        HttpEntity<OpenAIRequest> entityRequest = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Root> responseEntity = restTemplate.postForEntity(API_URL, entityRequest, Root.class);

        String responseText = "";

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            Root response = responseEntity.getBody();
            if (response != null && response.getChoices() != null && !response.getChoices().isEmpty()) {
                responseText = response.getChoices().get(0).getMessage().getContent();
            }
        } else {
            throw new RuntimeException("Failed to get a valid response from OpenAI.");
        }

        QuestionResponseDTO questionResponseDTO = new QuestionResponseDTO();
        questionResponseDTO.setId(entity.getId());
        questionResponseDTO.setOpenAIResponse(responseText);

        return questionResponseDTO;
    }
}
