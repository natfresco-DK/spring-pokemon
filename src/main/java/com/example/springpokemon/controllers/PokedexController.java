package com.example.springpokemon.controllers;

import com.example.springpokemon.models.Pokemon;
import com.example.springpokemon.services.PokedexService;
import com.example.springpokemon.utility.ConnectionManager;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Connection;
import java.util.List;

@Controller
public class PokedexController {
    private PokedexService pokeService = new PokedexService();

    @GetMapping("/fire")
    public ModelAndView getAllFire() {
        ModelAndView mav = new ModelAndView("example/fire");
        mav.addObject("firePokemons", pokeService.getAllFirePokemons());
        return mav;
    }

    @GetMapping("/single")
    public ModelAndView getSingleById(@RequestParam Integer id) {
        ModelAndView mav = new ModelAndView("single");
        mav.addObject("pokemon", pokeService.getPokemonByID(id));
        return mav;
    }

    @GetMapping("/all-by-primary")
    public ModelAndView getAllByPrimaryType(@RequestParam String type) {
        //Note: Remember to also send a primary type String to the model and view
        ModelAndView mav = new ModelAndView("by-type");
        mav.addObject("primaryType", type);
        mav.addObject("pokemons", pokeService.getPokemonByType(type));
        return mav;
    }

    @GetMapping("/count")
    public ModelAndView getCountPerType() {
        ModelAndView mav = new ModelAndView("count-per-type");
        mav.addObject("typeCounts", pokeService.getCountByType());
        return mav;
    }
}