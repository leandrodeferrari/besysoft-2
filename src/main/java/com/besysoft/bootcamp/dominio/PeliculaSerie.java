package com.besysoft.bootcamp.dominio;

import java.time.LocalDate;

public class PeliculaSerie {

    private Long id;
    private String titulo;
    private LocalDate fechaDeCreacion;
    private Byte calificacion;
    private Genero genero;

    public PeliculaSerie() {
    }

    public PeliculaSerie(Long id, String titulo, LocalDate fechaDeCreacion, Byte calificacion, Genero genero) {
        this.id = id;
        this.titulo = titulo;
        this.fechaDeCreacion = fechaDeCreacion;
        this.calificacion = calificacion;
        this.genero = genero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(LocalDate fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public Byte getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Byte calificacion) {
        this.calificacion = calificacion;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

}
