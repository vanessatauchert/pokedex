package com.vanessa.pokedex.repository;

import com.vanessa.pokedex.entities.Pokedex;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokedexRepository extends JpaRepository<Pokedex, Long> {


}
