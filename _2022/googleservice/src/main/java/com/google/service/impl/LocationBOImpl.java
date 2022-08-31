package com.google.service.impl;

import com.google.model.locationmodel.LocationRoot;
import com.google.service.LocationBO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class LocationBOImpl implements LocationBO {

    @Value("${cloudOfGoods.google.key}")
    private String googleKey;

    @Override
    @Cacheable(key = "#location.concat(' '+#componentsLocations)", value = "root")
    public LocationRoot getSingleLocationData(String location, List<String> componentsLocations) {

        String components = componentsLocations.stream()
                .map(Object::toString)
                .collect(Collectors.joining("|country:", "country:", ""));

        log.info("Getting Location Data From Google API " + location);

        String url = "https://maps.googleapis.com/maps/api/place/autocomplete/json?key=" + googleKey + "&input=" + location + "&components=" + components;
        log.info(url);

        ResponseEntity<LocationRoot> forEntity = new RestTemplate().getForEntity(url, LocationRoot.class);
        return forEntity.getBody();
    }


}
