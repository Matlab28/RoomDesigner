package com.example.roomdesigner.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
public class QuestionRequestDTO {
    private MultipartFile file;
    private String question;
}
