package com.cloudofgoods.model.placemodel;


import com.cloudofgoods.model.SuperModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceRoot implements SuperModel {
    @JsonProperty("html_attributions")
    public ArrayList<Object> html_attributions;
    @JsonProperty("result")
    public Result result;
    @JsonProperty("status")
    public String status;
}