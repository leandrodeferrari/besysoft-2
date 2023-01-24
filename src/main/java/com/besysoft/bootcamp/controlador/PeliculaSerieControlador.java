package com.besysoft.bootcamp.controlador;

import com.besysoft.bootcamp.dominio.Genero;
import com.besysoft.bootcamp.dominio.PeliculaSerie;
import com.besysoft.bootcamp.utilidad.FechaUtilidad;
import com.besysoft.bootcamp.utilidad.PeliculaSerieUtilidad;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/peliculas-series")
public class PeliculaSerieControlador {

    private List<Genero> generos;
    private List<PeliculaSerie> peliculasSeries;

    public PeliculaSerieControlador() {

        this.generos = new ArrayList<>(
                Arrays.asList(
                        new Genero(1, "Terror"),
                        new Genero(2, "Suspenso"),
                        new Genero(3, "Policial"),
                        new Genero(4, "Romance")
                )
        );

        this.peliculasSeries = new ArrayList<>(
                Arrays.asList(
                        new PeliculaSerie(1L, "Chucky", FechaUtilidad.formatear("12-12-2022"), (byte) 4, generos.get(0)),
                        new PeliculaSerie(2L, "Annabelle", FechaUtilidad.formatear("10-01-2020"), (byte) 3, generos.get(0)),
                        new PeliculaSerie(3L, "Jaula", FechaUtilidad.formatear("11-03-2021"), (byte) 4, generos.get(1)),
                        new PeliculaSerie(4L, "Culpable", FechaUtilidad.formatear("25-07-2019"), (byte) 2, generos.get(2)),
                        new PeliculaSerie(5L, "Viejos", FechaUtilidad.formatear("24-01-2023"), (byte) 5, generos.get(1)),
                        new PeliculaSerie(6L, "CODA", FechaUtilidad.formatear("15-02-2020"), (byte) 1, generos.get(3))
                )
        );

    }

    @GetMapping
    public ResponseEntity<?> buscarPorFiltros(@RequestParam(required = false) String titulo,
                                             @RequestParam(required = false) String nombreGenero){

        try {
            return ResponseEntity.ok
                    (PeliculaSerieUtilidad.buscarPorFiltros(this.peliculasSeries, titulo, nombreGenero));
        } catch(IllegalArgumentException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

    }

    @GetMapping("/fechas")
    public ResponseEntity<?> buscarPorFechas(@RequestParam String desde,
                                             @RequestParam String hasta){

        try {
            return ResponseEntity.ok(PeliculaSerieUtilidad.buscarPorFechas(peliculasSeries, desde, hasta));
        } catch (IllegalArgumentException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

    }

}
