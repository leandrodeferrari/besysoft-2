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

}
