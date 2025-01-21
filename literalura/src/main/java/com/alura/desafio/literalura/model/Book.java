package com.alura.desafio.literalura.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "Libro")
public class Book {
    @Id
    private Long id;
    private String titulo;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(
            name = "Libro_Autor",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
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
        this.autor_es=datosLibro.autores().stream().map(Author::new).collect(Collectors.toList());
        this.idioma_s=datosLibro.idioma();
        this.numeroDeDescargas= datosLibro.numeroDeDescargas();
    }

    public void setAutor_es(List<Author> autor_es) {
        this.autor_es = autor_es;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String autores= autor_es.stream().map(Author::getNombre).collect(Collectors.joining(" "));
        return "------- LIBRO -------\n" +
                "Titulo: " + titulo + "\n" +
                "Autor(es): " + autores +"\n" +
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
