package com.cloudofgoods.service;

import com.cloudofgoods.model.locationmodel.LocationRoot;

import java.util.List;

public interface LocationBO {
    LocationRoot getSingleLocationData(String location , List<String> componentsLocations);

}
