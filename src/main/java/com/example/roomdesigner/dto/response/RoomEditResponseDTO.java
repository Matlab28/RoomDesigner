package com.example.roomdesigner.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RoomEditResponseDTO {
    private Long id;
    private String imageBase64;
    private String maskBase64;
    private String prompt;
}
