package com.google.service;

import com.google.model.placemodel.PlaceRoot;

public interface PlaceDetailsBO {
    PlaceRoot getPlaceDetails(String placeId);
}
