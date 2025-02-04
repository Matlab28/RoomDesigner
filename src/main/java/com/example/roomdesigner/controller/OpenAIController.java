package com.example.roomdesigner.controller;

import com.example.roomdesigner.dto.request.QuestionRequestDTO;
import com.example.roomdesigner.dto.response.QuestionResponseDTO;
import com.example.roomdesigner.service.OpenAIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/openai")
@RequiredArgsConstructor
public class OpenAIController {
    private final OpenAIService service;

}
