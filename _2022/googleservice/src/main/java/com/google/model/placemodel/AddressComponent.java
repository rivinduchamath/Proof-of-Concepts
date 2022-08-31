package com.google.model.placemodel;

import com.google.model.SuperModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressComponent implements SuperModel {
    @JsonProperty("long_name")
    public String long_name;
    @JsonProperty("short_name")
    public String short_name;
    @JsonProperty("types")
    public ArrayList<String> types;
}