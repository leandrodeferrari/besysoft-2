package com.besysoft.bootcamp.utilidad;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class FechaUtilidad {

    public static LocalDate formatear(String fecha){

        DateTimeFormatter formateador = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .append(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                .toFormatter();

        return LocalDate.parse(fecha, formateador);

    }

    public static void validarRango(LocalDate desde, LocalDate hasta){

        if(desde.compareTo(hasta) > 0){
            throw new IllegalArgumentException("Rango inválido.");
        }

    }

}
