package com.example.roomdesigner.service;

import com.example.roomdesigner.dto.openAIGenImage.Root;
import com.example.roomdesigner.dto.request.ImageGenerationRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoomDesignService {
    private final ModelMapper modelMapper;
    private final RestTemplate restTemplate;
    @Value("${openai.api.key}")
    private String API_KEY;
    @Value("${openai.api.image.url}")
    private String API_URL;

    public Root generateImage(ImageGenerationRequestDto requestDto) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + API_KEY);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<ImageGenerationRequestDto> entity = new HttpEntity<>(requestDto, headers);

        ResponseEntity<Root> response = restTemplate.exchange(API_URL, HttpMethod.POST, entity, Root.class);

        return response.getBody();
    }
}
