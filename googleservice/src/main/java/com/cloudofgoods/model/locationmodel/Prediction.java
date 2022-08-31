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
public class Prediction implements SuperModel {

    @JsonProperty("description")
    public String description;
    @JsonProperty("matched_substrings")
    public ArrayList<MatchedSubstring> matchedSubstrings;
    @JsonProperty("place_id")
    public String place_id;
    @JsonProperty("reference")
    public String reference;
    @JsonProperty("structured_formatting")
    public StructuredFormatting structuredFormatting;
    @JsonProperty("terms")
    public ArrayList<Term> terms;
    @JsonProperty("types")
    public ArrayList<String> types;

}
