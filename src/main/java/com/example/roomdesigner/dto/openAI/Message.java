package com.example.roomdesigner.dto.openAI;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Message {
    private String role;
    private String content;
    private Object refusal;
}
