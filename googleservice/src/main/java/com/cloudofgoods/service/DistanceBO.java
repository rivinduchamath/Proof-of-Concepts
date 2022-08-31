package com.cloudofgoods.service;

import com.cloudofgoods.model.distancemodel.DistanceRoot;

public interface DistanceBO {
    DistanceRoot getDistance(String origins, String destinations);
}
