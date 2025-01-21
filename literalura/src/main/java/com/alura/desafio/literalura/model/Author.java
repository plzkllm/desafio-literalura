package com.alura.desafio.literalura.model;

import java.util.Date;
import java.util.List;

public class Author {
    private String nombre;
    private Date fechaDeNacimiento;
    private Date fechaDeFallecimiento;
    private List<String> nombresLibros;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public List<String> getNombresLibros() {
        return nombresLibros;
    }

    public void setNombresLibros(List<String> nombresLibros) {
        this.nombresLibros = nombresLibros;
    }

    public Date getFechaDeFallecimiento() {
        return fechaDeFallecimiento;
    }

    public void setFechaDeFallecimiento(Date fechaDeFallecimiento) {
        this.fechaDeFallecimiento = fechaDeFallecimiento;
    }
}
