package ru.geekbrains.homework9pages.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.homework9pages.models.Game;
import ru.geekbrains.homework9pages.service.ServiceApi;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class HomePagePcGameController {


    private ServiceApi serviceApi;

    @GetMapping
    public String getHomePage(){
        return "index.html";
    }
    @GetMapping("/all")
    public String homePage(Model model){
        model.addAttribute("pcgame", serviceApi.getAllPcGame());
        return "view-all-games.html";
    }

    @GetMapping("/pc-game-create")
    public String createPcGame(){
        return "pc-game-create.html";
    }
//
    @PostMapping("/pc-game-create")
    public String createPcGame(Game game){
        serviceApi.createPcGame(game);
        return "redirect:/";
    }

    @GetMapping("/pc-game-update/{id}")
    public String updatePcGameById(Game game){
        return "pc-game-update.html";
    }

    @PostMapping("/pc-game-update")
    public String updatePcGame(Game game){
        serviceApi.updatePcGameById(game);
        System.out.println(game.getPrice());
        return "redirect:/all";
    }

    @GetMapping("pc-game-delete/{id}")
    public String deleteUser(Game game){
        serviceApi.deleteById(game);
        return "redirect:/all";
    }
}
