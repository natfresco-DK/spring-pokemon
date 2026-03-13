package com.example.springpokemon.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Pokemon {
    private int pokedexNumber;
    private String name;

    private int speed;
    private int specialDefence;
    private int specialAttack;
    private int defence;
    private int attack;
    private int hp;

    private String primaryType;
    private String secondaryType;

    public Pokemon(){}
    public Pokemon(int pokedexNumber, String name, int speed, int specialDefence, int specialAttack, int defence, int attack, int hp, String primaryType, String secondaryType) {
        this.pokedexNumber = pokedexNumber;
        this.name = name;
        this.speed = speed;
        this.specialDefence = specialDefence;
        this.specialAttack = specialAttack;
        this.defence = defence;
        this.attack = attack;
        this.hp = hp;
        this.primaryType = primaryType;
        this.secondaryType = secondaryType;
    }

    public Pokemon(int pokedexNumber, String name, String primaryType){
        this.pokedexNumber = pokedexNumber;
        this.name = name;
        this.primaryType = primaryType;
    }

    public int getPokedexNumber() {
        return pokedexNumber;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public int getSpecialDefence() {
        return specialDefence;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public int getDefence() {
        return defence;
    }

    public int getAttack() {
        return attack;
    }

    public int getHp() {
        return hp;
    }

    public String getPrimaryType() {
        return primaryType;
    }

    public String getSecondaryType() {
        return secondaryType;
    }

    public static Pokemon parseString(ResultSet resultSet) throws SQLException {
        int pokedex_number = Integer.parseInt(resultSet.getString(1));
        String name = resultSet.getString(2);
        int speed = Integer.parseInt(resultSet.getString(3));
        int special_defence = Integer.parseInt(resultSet.getString(4));
        int special_attack = Integer.parseInt(resultSet.getString(5));
        int defence = Integer.parseInt(resultSet.getString(6));
        int attack = Integer.parseInt(resultSet.getString(7));
        int hp = Integer.parseInt(resultSet.getString(8));
        String primary_type = resultSet.getString(9);
        String secondary_type = resultSet.getString(10);
        return new Pokemon(pokedex_number,name,speed,special_defence,special_attack,defence,attack,hp,primary_type,secondary_type);

    }

    public int getCombinedStats(){
        return speed+specialDefence+specialAttack+defence+attack+hp;
    }
}