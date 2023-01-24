package com.besysoft.bootcamp.controlador;

import com.besysoft.bootcamp.dominio.Personaje;
import com.besysoft.bootcamp.utilidad.PersonajeUtilidad;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/personajes")
public class PersonajeControlador {

    private List<Personaje> personajes;

    public PersonajeControlador() {
        this.personajes = new ArrayList<>(
                Arrays.asList(
                        new Personaje(1L, "Jacqueline", (byte) 26, 55.7f, "Es una actriz canadiense. Protagonizó la serie Salvation de CBS."),
                        new Personaje(2L, "Vera", (byte) 86, 70.0f, "Supermodelo que enamoró a Coco Chanel y ahora ha conquistado a Paco Plaza."),
                        new Personaje(3L, "Christian", (byte) 35, 79.5f, "Es actor, escritor, director, productor y músico. Trabaja en el teatro, peliculas y televisión."),
                        new Personaje(4L, "Joel", (byte) 48, 90.2f, "Es actor, director y guionista australiano conocido por haber participado en la serie televisiva Teh secret life of us."),
                        new Personaje(5L, "Sofia", (byte) 29, 69.5f, "Nació en Lauderdale, Florida. Hijan de José F. Daccarett y de Laura Char Canson."),
                        new Personaje(6L, "Jeremy", (byte) 52, 80.5f, "Es actor, actor de voz, productor y músico estadounidense.")
                )
        );
    }

    @GetMapping
    public ResponseEntity<?> buscarPorFiltros(@RequestParam(required = false) String nombre,
                                              @RequestParam(required = false) Byte edad){

        try {
            return ResponseEntity.ok(PersonajeUtilidad.buscarPorFiltros(this.personajes, nombre, edad));
        } catch(IllegalArgumentException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

    }

}