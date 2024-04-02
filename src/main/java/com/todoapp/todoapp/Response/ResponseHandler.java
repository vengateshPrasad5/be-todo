package com.todoapp.todoapp.Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object> generateResponse
            (HttpStatus status, String message, Object objectResponse){

        Map<String,Object> map = new HashMap<>();
        map.put("message",message);
        map.put("status code", status);
        map.put("data",objectResponse);

        return new ResponseEntity<>(map,status);
    }
}
