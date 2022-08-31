package com.google.model.distancemodel;

import com.google.model.SuperModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Duration implements SuperModel {
    @JsonProperty("text")
    public String text;
    @JsonProperty("value")
    public int value;
}