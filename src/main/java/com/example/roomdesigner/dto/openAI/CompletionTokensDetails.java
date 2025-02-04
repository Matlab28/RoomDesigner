package com.example.roomdesigner.dto.openAI;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CompletionTokensDetails {
    @JsonProperty("reasoning_tokens")
    private Integer reasoningTokens;
    @JsonProperty("audio_tokens")
    private Integer audioTokens;
    @JsonProperty("accepted_prediction_tokens")
    private Integer acceptedPredictionTokens;
    @JsonProperty("rejected_prediction_tokens")
    private Integer rejectedPredictionTokens;
}
