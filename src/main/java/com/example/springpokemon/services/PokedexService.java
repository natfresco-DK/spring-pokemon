package com.example.springpokemon.services;

import com.example.springpokemon.models.Pokemon;
import com.example.springpokemon.repositories.PokedexRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

public class PokedexService {
    private PokedexRepository repo = new PokedexRepository();

    public List<Pokemon> getAllFire() throws SQLException {
        return repo.getALlFirePokemon();
    }

    public Pokemon getSingleById(String id) {
        try {
            return repo.getSingleById(id);
        } catch (SQLException e) {
            throw new NoSuchElementException("Could not fetch pokemon", e);
        }
    }

    public List<Pokemon> getAllPokemonByType(String type) throws SQLException{
        return repo.getAllPokemonByType(type);
    }
}
