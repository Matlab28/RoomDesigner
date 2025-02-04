package com.example.roomdesigner.controller;

import com.example.roomdesigner.dto.openAIGenImage.Root;
import com.example.roomdesigner.dto.request.ImageGenerationRequestDto;
import com.example.roomdesigner.service.ImageGenerationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/images")
@CrossOrigin(origins = "http://localhost:63342")
public class ImageGenerationController {

    private final ImageGenerationService imageGenerationService;

    public ImageGenerationController(ImageGenerationService imageGenerationService) {
        this.imageGenerationService = imageGenerationService;
    }

    @PostMapping("/generate")
    public Root generateImage(@RequestBody ImageGenerationRequestDto requestDto) {
        return imageGenerationService.generateImage(requestDto);
    }
}
