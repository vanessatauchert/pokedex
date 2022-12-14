package com.vanessa.pokedex.service;

import com.vanessa.pokedex.entities.Pokedex;
import com.vanessa.pokedex.repository.PokedexRepository;
import com.vanessa.pokedex.service.exceptions.DatabaseException;
import com.vanessa.pokedex.service.exceptions.ResourceNotFoundExcepetion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundExcepetion(id);
        }catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }

        }

        public Pokedex update(Long id, Pokedex obj){
        try {
            Pokedex entity = repository.getOne(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch(EntityNotFoundException e) {
            throw new ResourceNotFoundExcepetion(id);
        }
        }

    private void updateData(Pokedex entity, Pokedex obj) {
        entity.setName(obj.getName());
        entity.setCategory(obj.getCategory());
        entity.setHability(obj.getHability());
        entity.setHeight(obj.getHeight());
    }
}
