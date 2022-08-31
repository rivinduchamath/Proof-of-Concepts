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
public class Result implements SuperModel {
    @JsonProperty("address_components")
    public ArrayList<AddressComponent> address_components;
    @JsonProperty("adr_address")
    public String adr_address;
    @JsonProperty("formatted_address")
    public String formatted_address;
    @JsonProperty("geometry")
    public Geometry geometry;
    @JsonProperty("icon")
    public String icon;
    @JsonProperty("icon_background_color")
    public String icon_background_color;
    @JsonProperty("icon_mask_base_uri")
    public String icon_mask_base_uri;
    @JsonProperty("name")
    public String name;
    @JsonProperty("place_id")
    public String place_id;
    @JsonProperty("reference")
    public String reference;
    @JsonProperty("types")
    public ArrayList<String> types;
    @JsonProperty("url")
    public String url;
    @JsonProperty("utc_offset")
    public int utc_offset;
    @JsonProperty("vicinity")
    public String vicinity;
}