package com.example.springpokemon.controllers;
import com.example.springpokemon.services.BattleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BattleController {
    private BattleService battleService = new BattleService();

    @GetMapping("/battle")
    public ModelAndView battle(@RequestParam int id1, int id2) {
        ModelAndView mav = new ModelAndView("battle");
        mav.addObject("battleResults", battleService.getWinner(id1,id2));
        return mav;
    }


}
