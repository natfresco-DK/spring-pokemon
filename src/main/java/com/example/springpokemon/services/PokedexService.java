package com.example.springpokemon.services;

import com.example.springpokemon.models.Pokemon;
import com.example.springpokemon.repositories.PokedexRepository;

import java.util.List;
import java.util.Map;

public class PokedexService {
    private PokedexRepository repo = new PokedexRepository();

    public List<Pokemon> getAllFirePokemons(){
        return repo.getALlFirePokemon();
    }

    public Pokemon getPokemonByID(int id){
        return repo.getByID(id);
    }

    public List<Pokemon> getPokemonByType(String type){
        return repo.getAllPokemonByType(type);
    }

    public Map getCountByType(){
        return repo.getCountByType();
    }
}
