package com.google.model.placemodel;

import com.google.model.SuperModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Northeast implements SuperModel {
    @JsonProperty("lat")
    public double lat;
    @JsonProperty("lng")
    public double lng;
}