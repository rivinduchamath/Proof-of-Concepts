package com.cloudofgoods.controller;

import com.cloudofgoods.model.placemodel.PlaceRoot;
import com.cloudofgoods.service.PlaceDetailsBO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api/v5/google-service/place")
public class PlacesDetailsController {
    private final PlaceDetailsBO placeDetailsBO;

//    http://localhost:8000/api/v5/google-service/place/get/place/ChIJY_i8sNwgTIYR3N5jfvmPuS4
    @GetMapping("/get/place/{place}")
    public PlaceRoot getPlaceDetails(@PathVariable("place") String placeId) {
        log.info("Inside the PlacesDetailsController");

        return  placeDetailsBO.getPlaceDetails(placeId);
    }

}
