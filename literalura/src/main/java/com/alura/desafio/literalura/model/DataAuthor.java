package com.alura.desafio.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.time.LocalDate;

public record DataAuthor(
        @JsonAlias("name") String nombre,
        @JsonAlias("birth_year") LocalDate fechaDeNacimiento,
        @JsonAlias("death_year") LocalDate fechaDeFallecimiento
) {
}
