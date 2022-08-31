package com.google.service.impl;

import com.google.model.placemodel.PlaceRoot;
import com.google.service.PlaceDetailsBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static com.google.configarations.staticvariables.CommonStatic.*;

@Service
@Slf4j
public class PlaceDetailsBOImpl implements PlaceDetailsBO {

    @Override
    public PlaceRoot getPlaceDetails(String input) {

        String placeURL = PLACES_API_BASE + TYPE_DETAIL + OUT_JSON + "?placeid=" + URLEncoder.encode(input, StandardCharsets.UTF_8) +
                "&key=" + API_KEY;
        ResponseEntity<PlaceRoot> forEntity = new RestTemplate().getForEntity(placeURL, PlaceRoot.class);

        return forEntity.getBody();
    }
}
