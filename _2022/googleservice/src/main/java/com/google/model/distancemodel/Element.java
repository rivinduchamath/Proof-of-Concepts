package com.google.model.distancemodel;

import com.google.model.SuperModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Element implements SuperModel {
    @JsonProperty("distance")
    public Distance distance;
    @JsonProperty("duration")
    public Duration duration;
    @JsonProperty("status")
    public String status;
}