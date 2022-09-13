package com.vanessa.pokedex.service;

import com.vanessa.pokedex.entities.Pokedex;
import com.vanessa.pokedex.repository.PokedexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokedexService {

    @Autowired
    private PokedexRepository repository;

    public List<Pokedex> findAll(){
        return repository.findAll();
    }

    public Pokedex findById(Long id){
        Optional<Pokedex> obj = repository.findById(id);
        return obj.get();
        }

    public Pokedex insert(Pokedex obj){
    return repository.save(obj);
        }

}
