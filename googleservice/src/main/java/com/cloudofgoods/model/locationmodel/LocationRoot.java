package com.cloudofgoods.model.locationmodel;

import com.cloudofgoods.model.SuperModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationRoot implements SuperModel {

    @JsonProperty("predictions")
    public ArrayList<Prediction> predictions;
    @JsonProperty("status")
    public String status;
}