package com.example.roomdesigner.dto.request;

import com.example.roomdesigner.dto.openAI.Message;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class OpenAIRequest {
    private String model;
    private List<Message> messages;
    @JsonProperty("response_format")
    private ResponseFormat responseFormat;
    private Double temperature;
    @JsonProperty("max_tokens")
    private Integer maxTokens;
    @JsonProperty("top_p")
    private Double topP;
    @JsonProperty("frequency_penalty")
    private Double frequencyPenalty;
    @JsonProperty("presence_penalty")
    private Double presencePenalty;
}
