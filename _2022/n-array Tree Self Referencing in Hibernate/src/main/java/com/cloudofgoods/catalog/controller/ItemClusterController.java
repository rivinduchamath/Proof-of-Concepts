package com.cloudofgoods.catalog.controller;

import com.cloudofgoods.catalog.business.ItemClusterService;
import com.cloudofgoods.catalog.controller.controllconfig.ResponseHandler;
import com.cloudofgoods.catalog.dto.ItemClusterTypeDTO;
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
@RequestMapping("/api/v5/item/cluster")
public class ItemClusterController {

    private final ItemClusterService itemClusterService;

    @PostMapping("/save")
    @Description("Save Item Cluster (If Send With ID It Will Update)")
    public ResponseEntity<Object> saveItemCluster(@RequestBody ItemClusterTypeDTO itemClusterTypeDTO) {
        log.info(" LOG::Inside the ItemClusterController saveItemCluster " + itemClusterTypeDTO.getClusterType());
        try {
            log.info("LOG::Inside the ItemClusterController saveItemCluster Inside try");
            ItemClusterTypeDTO saveItem = itemClusterService.saveItemCluster(itemClusterTypeDTO);
            return ResponseHandler.responseBuilder("Success", "2000", HttpStatus.OK, saveItem);
        } catch (Exception e) {
            log.info("LOG::Inside the ItemClusterController saveItemCluster Exception :: " + e.getMessage());
            return ResponseHandler.responseBuilder("Fail", "5000", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

}
