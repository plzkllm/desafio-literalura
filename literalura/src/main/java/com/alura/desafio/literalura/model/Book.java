package com.alura.desafio.literalura.model;

public class Book {
    private Long id;
    private String titulo;
    private String autor;
    private String idioma;
    private Double numeroDeDescargas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "------- LIBRO -------\n" +
                "Titulo: " + titulo + "\n" +
                "Autor(es): " + autor + "\n" +
                "Idioma(s): " + idioma + "\n" +
                "Numero de descargas: " + numeroDeDescargas + "\n" +
                "--------------------";
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Double getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Double numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }
}
