package com.vanessa.pokedex.config;

import com.vanessa.pokedex.entities.Pokedex;
import com.vanessa.pokedex.repository.PokedexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private PokedexRepository pokedexRepository;


    @Override
    public void run(String[] args) throws Exception {

        Pokedex p1 = new Pokedex(null, "Pikachu", "Eletric", "Thunder Bolt", "5,0kg");
        Pokedex p2 = new Pokedex(null, "Charmander", "Fire", "Fire Bean", "4,0kg");

        pokedexRepository.saveAll(Arrays.asList(p1,p2));
    }


}
