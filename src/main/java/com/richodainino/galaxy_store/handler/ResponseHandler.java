package com.richodainino.galaxy_store.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.LinkedHashMap;


public class ResponseHandler {

    public static ResponseEntity<Object> generateResponse(HttpStatus httpStatus, String message, Object responseObj) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
        String status = httpStatus.is2xxSuccessful()? "success" : "error";
        map.put("status", status);
        map.put("message", message);
        if (responseObj != null) {
            map.put("data", responseObj);
        }
        return new ResponseEntity<Object>(map, httpStatus);
    }

}
