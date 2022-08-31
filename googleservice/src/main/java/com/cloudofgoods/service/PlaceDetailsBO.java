package com.cloudofgoods.service;

import com.cloudofgoods.model.placemodel.PlaceRoot;

public interface PlaceDetailsBO {
    PlaceRoot getPlaceDetails(String placeId);
}
