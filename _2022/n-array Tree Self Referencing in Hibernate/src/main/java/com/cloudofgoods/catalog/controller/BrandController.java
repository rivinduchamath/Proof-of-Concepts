package com.cloudofgoods.catalog.controller;

import com.cloudofgoods.catalog.business.BrandService;
import com.cloudofgoods.catalog.controller.controllconfig.ResponseHandler;
import com.cloudofgoods.catalog.dto.BrandDTO;
import jdk.jfr.Description;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v5/brand")
public class BrandController {

    private final BrandService brandService;

    @PostMapping("/save")
    @Description("Save Brand (If Send With ID It Will Update)")
    public ResponseEntity<Object> saveBrand(@RequestBody BrandDTO brandDTO) {
        log.info("LOG::Inside the BrandController saveBrand " + brandDTO.getBrandName());
        try {
            log.info("LOG::Inside the BrandController saveBrand Inside try");
            BrandDTO postResponse = brandService.saveBrand(brandDTO);
            return ResponseHandler.responseBuilder("Success", "2000", HttpStatus.OK, postResponse);
        } catch (Exception e) {
            log.info("LOG::Inside the BrandController saveBrand Exception :: " + e.getMessage());
            return ResponseHandler.responseBuilder("Fail", "5000", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
