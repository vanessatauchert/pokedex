package com.vanessa.pokedex.service;

import com.vanessa.pokedex.entities.Pokedex;
import com.vanessa.pokedex.repository.PokedexRepository;
import com.vanessa.pokedex.service.exceptions.ResourceNotFoundExcepetion;
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
        return obj.orElseThrow(()-> new ResourceNotFoundExcepetion(id));
        }

    public Pokedex insert(Pokedex obj){
    return repository.save(obj);
        }

        public void delete(Long id){
        repository.deleteById(id);
        }

        public Pokedex update(Long id, Pokedex obj){
        Pokedex entity = repository.getOne(id);
        updateData(entity, obj);
        return repository.save(entity);
        }

    private void updateData(Pokedex entity, Pokedex obj) {
        entity.setName(obj.getName());
        entity.setCategory(obj.getCategory());
        entity.setHability(obj.getHability());
        entity.setHeight(obj.getHeight());
    }
}
