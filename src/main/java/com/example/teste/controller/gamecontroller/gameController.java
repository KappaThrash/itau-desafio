package com.example.teste.controller.gamecontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/games")
public class gameController {

    int[] games = {1,2,3,4,5};

    @GetMapping(path = "/1")
    public Game getGame() {
        return new Game("Half-life 2", "FPS");
    }
}
