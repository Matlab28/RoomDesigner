package com.example.roomdesigner.dto.request;

import lombok.Data;

@Data
public class RoomEditRequestDTO {
    private String imageBase64;
    private String maskBase64;
    private String prompt;
}
