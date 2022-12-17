package com.cloudofgoods.catalog.controller;

import com.cloudofgoods.catalog.business.CachingDeleteBO;
import com.cloudofgoods.catalog.business.CategoryService;
import com.cloudofgoods.catalog.controller.controllconfig.ResponseHandler;
import com.cloudofgoods.catalog.dto.CategoryDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import jdk.jfr.Description;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v5/category")
public class CategoryController {
    private final CategoryService categoryService;
    private final CachingDeleteBO cachingService;

    @GetMapping(value = "/all/children", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Description("Get All Children Under Given Node (Only Next Children Set)")
    public ResponseEntity<Object> getChildNodes() {
        try {
            List<CategoryDTO> result = categoryService.getAllCategory("category");
           String json =result.get(0).getChildren().toString();

            return ResponseHandler.responseBuilder("Success", "2000", HttpStatus.OK,json);
        } catch (Exception e) {
            log.info("LOG::CategoryController getChildNodes Fail " + e.getMessage());
            return ResponseHandler.responseBuilder("Fail", "5000", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @RequestMapping(value = "/get/children/{categoryId}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @Description("This will Return All Next Level Children ")
    public ResponseEntity<Object> getCategoryId(@PathVariable(name = "categoryId") Long categoryId) {
        try {
            Date startTime = new Date();
            List<CategoryDTO> opList = categoryService.getAllCategoryUnderParent(categoryId, "category");
            log.info("size of child list " + opList.size());
            Date endTime = new Date();
            log.info(" Execution time " + (startTime.getTime() - endTime.getTime()) / 1000);
            return ResponseHandler.responseBuilder("Success", "2000", HttpStatus.OK, opList);
        } catch (Exception e) {
            return ResponseHandler.responseBuilder("Fail", "5000", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PostMapping("/save")
    @Description("Save Catalog (If Send With ID It Will Update)")
    public ResponseEntity<Object> saveCategory(@RequestBody CategoryDTO categoryDTO) {
        log.info(categoryDTO + " LOG::Inside the CatalogController saveCategory ");
        if (categoryDTO.getId() != 1L) {
            try {
                log.info("LOG::Inside the CatalogController saveCategory Inside try");
                cachingService.deleteAllCache();
                CategoryDTO saveCategoryDTO = categoryService.saveCategory(categoryDTO);
                return categoryDTO.getId() != null ?
                        ResponseHandler.responseBuilder("Success", "2000", HttpStatus.OK, saveCategoryDTO) :
                        ResponseHandler.responseBuilder("CannotFindValues", "4000", HttpStatus.BAD_REQUEST, saveCategoryDTO);
            } catch (Exception e) {
                log.info("LOG::Inside the CatalogController saveCategory Exception :: " + e.getMessage());
                return ResponseHandler.responseBuilder("Fail", "5000", HttpStatus.INTERNAL_SERVER_ERROR, null);
            }
        }
        return ResponseHandler.responseBuilder("CantModifyRoot", "4000", HttpStatus.BAD_REQUEST, null);
    }

    @Transactional
    @PutMapping(value = "/update/nodeId/{nodeId}/parentId/{parentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> replaceParent(@PathVariable("nodeId") long nodeId, @PathVariable("parentId") long parentId) {
        if (nodeId != 1L) {
            try {
                log.info("LOG::Inside the CatalogController replaceParent Inside try");
                cachingService.deleteAllCache();
                CategoryDTO categoryDTO = categoryService.replaceParent(nodeId, parentId);
                return categoryDTO.getId() != null ?
                        ResponseHandler.responseBuilder("Success", "2000", HttpStatus.OK, categoryDTO) :
                        ResponseHandler.responseBuilder("CannotFindValues", "4000", HttpStatus.BAD_REQUEST, categoryDTO);
            } catch (Exception e) {
                log.info("LOG::Inside the CatalogController replaceParent Exception :: " + e.getMessage());
                return ResponseHandler.responseBuilder("Fail", "5000", HttpStatus.INTERNAL_SERVER_ERROR, null);
            }
        } else {
            return ResponseHandler.responseBuilder("CantModifyRoot", "4000", HttpStatus.BAD_REQUEST, null);
        }
    }
}
