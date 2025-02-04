package com.example.roomdesigner.controller;

import com.example.roomdesigner.service.OpenAIService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.roomdesigner.dto.request.RoomEditRequestDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/room-designer")
public class RoomDesignerController {

    private final OpenAIService openAiService;

    public RoomDesignerController(OpenAIService openAiService) {
        this.openAiService = openAiService;
    }

    @PostMapping(value = "/edit", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Map<String, String>> editRoom(
            @RequestParam("file") MultipartFile file,
            @RequestParam("prompt") String prompt) {

        try {
            String editedImageUrl = openAiService.processRoomImage(file, prompt);
            return ResponseEntity.ok(Collections.singletonMap("editedImageUrl", editedImageUrl));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("error", e.getMessage()));
        }
    }
}
