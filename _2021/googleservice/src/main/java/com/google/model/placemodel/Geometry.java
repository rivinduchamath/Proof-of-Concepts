package com.google.model.placemodel;


import com.google.model.SuperModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Geometry implements SuperModel {

    @JsonProperty("location")
    public Location location;
    @JsonProperty("viewport")
    public Viewport viewport;
}
