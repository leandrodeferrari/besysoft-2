package com.besysoft.bootcamp.utilidad;

import com.besysoft.bootcamp.dominio.Personaje;

import java.util.List;
import java.util.stream.Collectors;

public class PersonajeUtilidad {

    public static List<Personaje> buscarPorFiltros(List<Personaje> personajes,
                                                   String nombre, Byte edad){

        if(nombre == null && edad == null){
            return personajes;
        }

        if (nombre != null && edad != null){
            return personajes.stream()
                    .filter(p -> p.getEdad().equals(edad) && p.getNombre().equalsIgnoreCase(nombre))
                    .collect(Collectors.toList());
        }

        if(nombre != null){
            return personajes.stream()
                    .filter(p -> p.getNombre().equalsIgnoreCase(nombre)).collect(Collectors.toList());
        } else {
            return personajes.stream()
                    .filter(p -> p.getEdad().equals(edad)).collect(Collectors.toList());
        }

    }

    public static List<Personaje> buscarPorEdades(List<Personaje> personajes,
                                                   Byte desde, Byte hasta){

        validarEdad(desde);
        validarEdad(hasta);
        ValidacionGeneralUtilidad.validarRangoDeNumeros(desde, hasta);

        return personajes.stream()
                .filter(p -> p.getEdad() >= desde && p.getEdad() <= hasta)
                .collect(Collectors.toList());

    }

    private static void validarEdad(Byte edad){

        if(edad == null){
            throw new IllegalArgumentException("La edad no puede ser nula.");
        }

        if(edad < 1){
            throw new IllegalArgumentException("La edad no puede ser menor a 0.");
        }

    }

}
