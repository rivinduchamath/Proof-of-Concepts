package com.google.cache;

import com.google.dto.RequestLocationDTO;
import com.google.model.locationmodel.LocationRoot;
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
@RequestMapping("/api/v5/location")
public class RedisController {

    private final TestRedisConfiguration locationBO;

    @PostMapping("/test/data/add")
    public List<LocationRoot> testAddData() {
        List<LocationRoot> responseResponseEntity = new ArrayList<>();

        log.info("Inside the Controller");
        try {
            for (int i = 0; i < 100000; i++) {
                responseResponseEntity.add(locationBO.getSingleLocationData(i));
            }
            return responseResponseEntity;

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Location Not Found Or Error");
        }
        return responseResponseEntity;
    }


    @PostMapping("/get")
    public LocationRoot getLocationTest(@RequestBody RequestLocationDTO requestDTO) {
        log.info("Inside the Controller");

        LocationRoot responseResponseEntity = null;
        try {
            responseResponseEntity = locationBO.getSingleLocationData(3);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Location Not Found Or Error");
        }
        assert responseResponseEntity != null;
        return responseResponseEntity;
    }
}
