package com.example.springpokemon.services;

import com.example.springpokemon.models.BattleResults;
import com.example.springpokemon.models.Pokemon;
import com.example.springpokemon.repositories.PokedexRepository;

import java.util.ArrayList;

public class BattleService {
    private PokedexRepository repo = new PokedexRepository();

    public BattleResults getWinner(int id1, int id2){
        Pokemon poke1 = repo.getByID(id1);
        Pokemon poke2 = repo.getByID(id2);
        BattleResults battleResults = new BattleResults(poke1,poke2);
        return battleResults;
    }
}