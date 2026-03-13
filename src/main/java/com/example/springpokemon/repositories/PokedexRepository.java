package com.example.springpokemon.repositories;

import com.example.springpokemon.models.Pokemon;
import com.example.springpokemon.utility.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PokedexRepository {
    private ConnectionManager conn = new ConnectionManager();

    public List<Pokemon> getALlFirePokemon(){
        List<Pokemon> allFirePokemon = new ArrayList<>();
        try{
            Connection database = conn.getConnection();
            PreparedStatement preparedStatement = database.prepareStatement("SELECT * FROM pokemon WHERE primary_type = ?");
            preparedStatement.setString(1, "Fire");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                allFirePokemon.add(Pokemon.parseString(rs));
            }
            database.close();
        }
        catch(Exception e){
            System.out.println("Could not prepare statement");
        }
        return allFirePokemon;
    }

    public Pokemon getByID(int pokedexNumber){
        try{
            Connection database = conn.getConnection();
            PreparedStatement psts = database.prepareStatement("SELECT * FROM pokemon where pokedex_number = ?");
            psts.setInt(1,pokedexNumber);
            ResultSet rs = psts.executeQuery();
            while(rs.next()) {
                return Pokemon.parseString(rs);
            }
            database.close();
        }catch(Exception e){
            System.out.println("Could not prepare statement");
        }
       return new Pokemon();
    }

    public List<Pokemon> getAllPokemonByType(String type){
        List<Pokemon> allPokemon = new ArrayList<>();
        try{
            Connection database = conn.getConnection();
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

    public Map<String, Integer> getCountByType(){
        HashMap<String, Integer> countByType = new HashMap<>();
        try{
            Connection database = conn.getConnection();
            PreparedStatement preparedStatement = database.prepareStatement(
                    "SELECT primary_type, COUNT(primary_type) FROM pokemon group by primary_type");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                countByType.put(rs.getString(1), rs.getInt(2));
            }
            database.close();
        }
        catch(Exception e){
            System.out.println("Could not prepare statement");
        }
        return countByType;
    }
}
