package com.cloudofgoods.catalog.controller.controllconfig;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object> responseBuilder(String message, String customCode, HttpStatus httpStatus, Object responseObject) {
        return getObjectResponseEntity(message, customCode, httpStatus, responseObject);
    }

    private static ResponseEntity<Object> getObjectResponseEntity(String message, String customCode, HttpStatus httpStatus, Object responseObject) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("code", customCode);
        response.put("HttpStatus", httpStatus);
        response.put("data", responseObject);
        return new ResponseEntity<>(response, httpStatus);
    }

    public static ResponseEntity<?> getObjectResponseEntityForCategory(String message, String customCode, HttpStatus httpStatus, Map responseObject) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("code", customCode);
        response.put("HttpStatus", httpStatus);
        response.put("data", responseObject);
        return new ResponseEntity<>(response, httpStatus);
    }
}
