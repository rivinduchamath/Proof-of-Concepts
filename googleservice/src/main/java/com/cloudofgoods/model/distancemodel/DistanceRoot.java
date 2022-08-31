package com.cloudofgoods.model.distancemodel;

import com.cloudofgoods.model.SuperModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistanceRoot implements SuperModel {
    @JsonProperty("destination_addresses")
    public ArrayList<String> destination_addresses;
    @JsonProperty("origin_addresses")
    public ArrayList<String> origin_addresses;
    @JsonProperty("rows")
    public ArrayList<Row> rows;
    @JsonProperty("status")
    public String status;
}