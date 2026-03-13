package com.example.springpokemon.repositories;

import com.example.springpokemon.models.Pokemon;
import com.example.springpokemon.utility.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class PokedexRepository {

    public List<Pokemon> getALlFirePokemon() throws SQLException {
        List<Pokemon> allFirePokemon = new ArrayList<>();

        Connection database = new ConnectionManager().getConnection();
        PreparedStatement preparedStatement = database.prepareStatement("SELECT * FROM pokemon WHERE primary_type = ?");
        preparedStatement.setString(1, "Fire");
        ResultSet rs = preparedStatement.executeQuery();

        while(rs.next()){
            Pokemon pokemon = new Pokemon(
                    rs.getInt("pokedex_number"),
                    rs.getString("name"),
                    rs.getInt("speed"),
                    rs.getInt("special_defence"),
                    rs.getInt("special_attack"),
                    rs.getInt("defence"),
                    rs.getInt("attack"),
                    rs.getInt("hp"),
                    rs.getString("primary_type"),
                    rs.getString("secondary_type")
            );
            allFirePokemon.add(pokemon);
        }
        return allFirePokemon;
    }

    public Pokemon getSingleById(String id) throws SQLException, NoSuchElementException {
        Connection database = new ConnectionManager().getConnection();
        PreparedStatement preparedStatement = database.prepareStatement("SELECT * FROM pokemon WHERE pokedex_number = ?");
        preparedStatement.setInt(1, Integer.parseInt(id));
        ResultSet rs = preparedStatement.executeQuery();

        if(rs.next() == false){
            throw new NoSuchElementException();
        }

        return new Pokemon(
                rs.getInt("pokedex_number"),
                rs.getString("name"),
                rs.getInt("speed"),
                rs.getInt("special_defence"),
                rs.getInt("special_attack"),
                rs.getInt("defence"),
                rs.getInt("attack"),
                rs.getInt("hp"),
                rs.getString("primary_type"),
                rs.getString("secondary_type")
        );
    }

    public List<Pokemon> getAllPokemonByType(String type){
        List<Pokemon> allPokemon = new ArrayList<>();
        try{
            Connection database = new ConnectionManager().getConnection();
            PreparedStatement preparedStatement = database.prepareStatement("SELECT * FROM pokemon WHERE primary_type = ?");
            preparedStatement.setString(1, type);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                allPokemon.add(Pokemon.parseString(rs));
            }
            database.close();
        }
        catch(Exception e){
            System.out.println("Could not prepare statement");
        }
        return allPokemon;
    }
}
