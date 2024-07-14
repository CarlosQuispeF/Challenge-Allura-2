package com.example.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T fromJson(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException("Error deserializing JSON: " + e.getMessage(), e);
        }
    }

    // Puedes añadir métodos adicionales para la serialización de objetos a JSON si es necesario
}
