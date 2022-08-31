package com.cloudofgoods.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.StringJoiner;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestLocationDTO implements Serializable {
    private String location;
    private List<String> requestLocations;
}
