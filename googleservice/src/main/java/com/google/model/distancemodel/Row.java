package com.google.model.distancemodel;


import com.google.model.SuperModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Row implements SuperModel {
    @JsonProperty("elements")
    public ArrayList<Element> elements;
}
