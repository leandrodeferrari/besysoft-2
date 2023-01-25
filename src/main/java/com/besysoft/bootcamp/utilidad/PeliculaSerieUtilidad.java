package com.besysoft.bootcamp.utilidad;

import com.besysoft.bootcamp.dominio.PeliculaSerie;

import java.time.LocalDate;

import java.util.List;
import java.util.stream.Collectors;

public class PeliculaSerieUtilidad {

    public static List<PeliculaSerie> buscarPorFiltros(List<PeliculaSerie> peliculasSeries,
                                                       String titulo, String nombreGenero){

        if(titulo == null && nombreGenero == null){
            return peliculasSeries;
        }

        if(titulo != null && nombreGenero != null){
            return peliculasSeries.stream()
                    .filter(ps -> ps.getTitulo().equalsIgnoreCase(titulo) &&
                            ps.getGenero().getNombre().equalsIgnoreCase(nombreGenero))
                    .collect(Collectors.toList());
        }

        if(titulo != null){
            return peliculasSeries.stream()
                    .filter(ps -> ps.getTitulo().equalsIgnoreCase(titulo)).collect(Collectors.toList());
        } else {
            return peliculasSeries.stream()
                    .filter(ps -> ps.getGenero().getNombre().equalsIgnoreCase(nombreGenero)).collect(Collectors.toList());
        }

    }

    public static List<PeliculaSerie> buscarPorFechas(List<PeliculaSerie> peliculasSeries, String desde, String hasta){

        LocalDate fechaInicio = FechaUtilidad.formatear(desde);
        LocalDate fechaFinal = FechaUtilidad.formatear(hasta);
        FechaUtilidad.validarRango(fechaInicio, fechaFinal);

        return peliculasSeries.stream()
                .filter(ps -> ps.getFechaDeCreacion().isAfter(fechaInicio) && ps.getFechaDeCreacion().isBefore(fechaFinal))
                .collect(Collectors.toList());

    }

    public static List<PeliculaSerie> buscarPorCalificaciones(List<PeliculaSerie> peliculasSeries, Byte desde, Byte hasta){

        validarCalificacion(desde);
        validarCalificacion(hasta);
        ValidacionGeneralUtilidad.validarRangoDeNumeros(desde, hasta);

        return peliculasSeries.stream()
                .filter(ps -> ps.getCalificacion() >= desde && ps.getCalificacion()<= hasta)
                .collect(Collectors.toList());

    }

    private static void validarCalificacion(Byte calificacion){

        if(calificacion == null){
            throw new IllegalArgumentException("La calificación no puede ser nula.");
        }

        if(calificacion < 1 || calificacion > 5){
            throw new IllegalArgumentException("La calificación no puede ser menor a 1 o mayor a 5.");
        }

    }

}
