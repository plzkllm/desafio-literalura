package com.alura.desafio.literalura.service;

public interface IConvertidorDeDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
