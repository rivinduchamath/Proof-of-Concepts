package com.cloudofgoods.model.placemodel;

import com.cloudofgoods.model.SuperModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Viewport implements SuperModel {
    @JsonProperty("northeast")
    public Northeast northeast;
    @JsonProperty("southwest")
    public Southwest southwest;
}