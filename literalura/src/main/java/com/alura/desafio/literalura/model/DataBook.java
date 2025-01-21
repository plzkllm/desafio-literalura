package com.alura.desafio.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record DataBook(
        @JsonAlias("id") Long id,
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<Author> autores,
        @JsonAlias("languages") List<String> idioma,
        @JsonAlias("download_count") Double numeroDeDescargas
) {
}
