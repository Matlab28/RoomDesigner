package com.example.roomdesigner.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ImageGenerationRequestDto {
    private String model = "dall-e-3";
    private String prompt;
    private int n = 1;
    private String size = "1024x1024";
}
