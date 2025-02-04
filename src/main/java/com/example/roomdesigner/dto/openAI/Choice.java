package com.example.roomdesigner.dto.openAI;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Choice {
    private Integer index;
    private Message message;
    private Object logprobs;
    @JsonProperty("finish_reason")
    private String finishReason;
}
