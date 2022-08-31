package com.google.service;

import com.google.model.distancemodel.DistanceRoot;

public interface DistanceBO {
    DistanceRoot getDistance(String origins, String destinations);
}
