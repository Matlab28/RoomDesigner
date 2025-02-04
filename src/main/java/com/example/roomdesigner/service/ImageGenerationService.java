package com.example.roomdesigner.service;

import com.example.roomdesigner.dto.openAIGenImage.Root;
import com.example.roomdesigner.dto.request.ImageGenerationRequestDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class ImageGenerationService {

    private final RestTemplate restTemplate;

    @Value("${openai.api.key}") // Set in application.properties
    private String openAiApiKey;

    public ImageGenerationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Root generateImage(ImageGenerationRequestDto requestDto) {
        String url = "https://api.openai.com/v1/images/generations";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + openAiApiKey);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<ImageGenerationRequestDto> entity = new HttpEntity<>(requestDto, headers);

        ResponseEntity<Root> response = restTemplate.exchange(url, HttpMethod.POST, entity, Root.class);

        return response.getBody();
    }
}
