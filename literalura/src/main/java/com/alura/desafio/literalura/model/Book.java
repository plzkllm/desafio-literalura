package com.alura.desafio.literalura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Libro")
public class Book {
    @Id
    private Long id;
    @Column(unique = true)
    private String titulo;

    @ManyToMany(mappedBy = "nombresLibros")
    private List<Author> autor_es;

    private List<String> idioma_s;
    private Double numeroDeDescargas;

    public Book(){

    }

    public List<String> getIdioma_s() {
        return idioma_s;
    }

    public void setIdioma_s(List<String> idioma_s) {
        this.idioma_s = idioma_s;
    }

    public Book(DataBook datosLibro) {
        this.id=datosLibro.id();
        this.titulo= datosLibro.titulo();
        this.autor_es=datosLibro.autores();
        this.idioma_s=datosLibro.idioma();
        this.numeroDeDescargas= datosLibro.numeroDeDescargas();
    }

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
                "Autor(es): " + autor_es + "\n" +
                "Idioma(s): " + idioma_s + "\n" +
                "Numero de descargas: " + numeroDeDescargas + "\n" +
                "--------------------";
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Double numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }
}
