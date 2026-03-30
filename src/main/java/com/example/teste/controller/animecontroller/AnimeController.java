package com.example.teste.controller.animecontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping(path = "/animes")
public class AnimeController {

    @GetMapping(path = "/1")
    public List<Anime> getAnime() {
        List<Anime> animes = new ArrayList<>();
        animes.add(new Anime("Ergo Proxy","Psychological", 2005));
        animes.add(new Anime("Azumanga Daioh","Slice Of Life", 2002));

        return animes;
    }
}
