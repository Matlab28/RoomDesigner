package com.example.roomdesigner.dto.openAI;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PromptTokensDetails {
    @JsonProperty("cached_tokens")
    private Integer cachedTokens;
    @JsonProperty("audio_tokens")
    private Integer audioTokens;
}
