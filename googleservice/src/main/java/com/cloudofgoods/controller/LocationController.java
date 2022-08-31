package com.cloudofgoods.controller;

import com.cloudofgoods.dto.RequestLocationDTO;
import com.cloudofgoods.model.locationmodel.LocationRoot;
import com.cloudofgoods.service.LocationBO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api/v5/google-service/location")
public class LocationController {
    private final LocationBO locationBO;

    @PostMapping("/getLocations")
    public LocationRoot getLocation(@RequestBody RequestLocationDTO requestDTO) {
        log.info("Inside the Controller");

        List<String> componentsLocations = new ArrayList<>(requestDTO.getRequestLocations());

        LocationRoot responseResponseEntity = null;
        try {
            responseResponseEntity = locationBO.getSingleLocationData(requestDTO.getLocation(), componentsLocations);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Location Not Found Or Error");
        }
        assert responseResponseEntity != null;
        return responseResponseEntity;
    }


}
