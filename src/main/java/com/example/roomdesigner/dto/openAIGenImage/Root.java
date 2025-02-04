package com.example.roomdesigner.dto.openAIGenImage;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
public class Root {
    private int created;
    private ArrayList<Datum> data;
}
