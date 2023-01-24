package com.besysoft.bootcamp.dominio;

public class PersonajePeliculaSerie {

    private Long id;
    private Personaje personaje;
    private PeliculaSerie peliculaSerie;

    public PersonajePeliculaSerie() {
    }

    public PersonajePeliculaSerie(Long id, Personaje personaje, PeliculaSerie peliculaSerie) {
        this.id = id;
        this.personaje = personaje;
        this.peliculaSerie = peliculaSerie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public PeliculaSerie getPeliculaSerie() {
        return peliculaSerie;
    }

    public void setPeliculaSerie(PeliculaSerie peliculaSerie) {
        this.peliculaSerie = peliculaSerie;
    }

}
