package com.cloudofgoods.controller;

import com.cloudofgoods.model.distancemodel.DistanceRoot;
import com.cloudofgoods.service.DistanceBO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api/v5/google-service/distance")
public class DistanceController {

    private final DistanceBO distanceBO;


//    http://localhost:8000/api/v5/google-service/distance/get?origins=galle&destinations=colombo
//    http://localhost:8000/api/v5/google-service/distance/distance/get?origins=40.6655101%2C-73.89188969999998&destinations=40.659569%2C-73.933783

    @PostMapping("/get")
    public DistanceRoot getPlaceDetails(@RequestParam("origins") String origins, @RequestParam("destinations") String destinations) {
        log.info("Inside the DistanceController");
        return distanceBO.getDistance(origins, destinations);
    }


}
