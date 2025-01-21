package com.alura.desafio.literalura.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Autor")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único de Autor
    @Column(unique = true)
    private String nombre;
    private Integer fechaDeNacimiento;
    private Integer fechaDeFallecimiento;

    public Author(String nombre, Integer fechaDeNacimiento, Integer fechaDeFallecimiento) {
        this.nombre=nombre;
        this.fechaDeNacimiento=fechaDeNacimiento;
        this.fechaDeFallecimiento=fechaDeFallecimiento;

    }

    @Override
    public String toString() {
        return "-------- Author --------" +
                "Nombre:"  + nombre + "\n" +
                "fechaDeNacimiento: " + fechaDeNacimiento + "\n" +
                "fechaDeFallecimiento: " + fechaDeFallecimiento + "\n" +
                ", id=" + id + "\n" +
                "-----------------------"
                ;
    }

    @ManyToMany(mappedBy = "autor_es")
    private List<Book> nombresLibros;

    public Author(){

    }

    public Author(DataAuthor autor){
        this.nombre= autor.nombre();
        this.fechaDeNacimiento=autor.fechaDeNacimiento();
        this.fechaDeFallecimiento=autor.fechaDeFallecimiento();
    }

    public Long getId() {
        return id;
    }

    public List<Book> getNombresLibros() {
        return nombresLibros;
    }

    public void setNombresLibros(List<Book> nombresLibros) {
        this.nombresLibros = nombresLibros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Integer fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public Integer getFechaDeFallecimiento() {
        return fechaDeFallecimiento;
    }

    public void setFechaDeFallecimiento(Integer fechaDeFallecimiento) {
        this.fechaDeFallecimiento = fechaDeFallecimiento;
    }
}
