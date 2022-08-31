package com.google.service.impl;

import com.google.model.distancemodel.DistanceRoot;
import com.google.service.DistanceBO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import static com.google.configarations.staticvariables.CommonStatic.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class DistanceBOImpl implements DistanceBO {

    @Value("${cloudOfGoods.google.key}")
    private String googleKey;

    @Override
    public DistanceRoot getDistance(String origins, String destinations) {

        log.info("Distance Service");

        String destinationUrl = DESTINATION_API_BASE + OUT_JSON + "?origins=" +origins +
                "&destinations=" + destinations + "&key=" + googleKey;

        ResponseEntity<DistanceRoot> forEntity = new RestTemplate().getForEntity(destinationUrl, DistanceRoot.class);

        return forEntity.getBody();
    }
}
