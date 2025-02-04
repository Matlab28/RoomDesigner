//package com.example.roomdesigner.controller;
//
//import com.example.roomdesigner.dto.request.RoomEditRequestDTO;
//import com.example.roomdesigner.service.OpenAIService;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.util.Base64;
//
//@RestController
//@RequestMapping("/api/room")
//public class RoomController {
//
//    private final OpenAIService openAIService;
//
//    public RoomController(OpenAIService openAIService) {
//        this.openAIService = openAIService;
//    }
//
//    @PostMapping(path = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<String> uploadRoomImage(@RequestParam("file") MultipartFile file) {
//        try {
//            // Convert file to Base64
//            String base64Image = Base64.getEncoder().encodeToString(file.getBytes());
//            openAIService.editRoom()
//            return ResponseEntity.ok(base64Image); // Return base64 string for further processing
//        } catch (IOException e) {
//            return ResponseEntity.badRequest().body("File upload failed");
//        }
//    }
//}
