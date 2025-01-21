package com.alura.desafio.literalura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertidorDeDatos implements IConvertidorDeDatos{
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            return objectMapper.readValue(json,clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
