package com.example.roomdesigner.dto.openAIGenImage;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Datum {
    @JsonProperty("revised_prompt")
    private String revisedPrompt;
    private String url;
}
