package com.cloudofgoods.catalog.controller;

import com.cloudofgoods.catalog.business.ItemService;
import com.cloudofgoods.catalog.controller.controllconfig.ResponseHandler;
import com.cloudofgoods.catalog.dto.ItemDTO;
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
@RequestMapping("/api/v5/item")
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/save")
    @Description("Save Item (If Send With ID It Will Update)")
    public ResponseEntity<Object> saveItem(@RequestBody ItemDTO itemDTO) {
        log.info(itemDTO + " LOG::Inside the ItemController saveItem ");
        try {
            log.info("LOG::Inside the ItemController saveItem Inside try");

            ItemDTO saveItem = itemService.saveItem(itemDTO);

            return ResponseHandler.responseBuilder("Success", "2000", HttpStatus.OK, saveItem);
        } catch (Exception e) {
            log.info("LOG::Inside the ItemController saveItem Exception :: " + e.getMessage());
            return ResponseHandler.responseBuilder("Fail", "5000", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

}

