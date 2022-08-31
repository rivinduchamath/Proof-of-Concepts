package com.google.service;

import com.google.model.locationmodel.LocationRoot;

import java.util.List;

public interface LocationBO {
    LocationRoot getSingleLocationData(String location , List<String> componentsLocations);

}
