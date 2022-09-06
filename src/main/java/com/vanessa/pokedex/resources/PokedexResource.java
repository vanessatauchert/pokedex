package com.vanessa.pokedex.resources;

import com.vanessa.pokedex.entities.Pokedex;
import com.vanessa.pokedex.service.PokedexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pokemons")
public class PokedexResource {

    @Autowired
    private PokedexService service;

    @GetMapping
    public ResponseEntity<List<Pokedex>> findAll() {
        List<Pokedex> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pokedex> findById(@PathVariable Long id) {
        Pokedex obj = service.findById(id);
        return ResponseEntity.ok().body(obj);

    }



}
