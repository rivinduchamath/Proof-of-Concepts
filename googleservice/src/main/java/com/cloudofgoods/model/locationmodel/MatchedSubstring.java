package com.cloudofgoods.model.locationmodel;

import com.cloudofgoods.model.SuperModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchedSubstring  implements SuperModel {

    @JsonProperty("length")
    public int length;
    @JsonProperty("offset")
    public int offset;
}