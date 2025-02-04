package com.example.roomdesigner.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
public class QuestionResponseDTO {
    private Long id;
    private String openAIResponse;
}
