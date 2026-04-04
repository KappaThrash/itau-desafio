package com.example.teste.controller.transacao.estatisticas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estatisticas")
public class EstatisticasController{

    private final EstatisticaService service;

    public EstatisticasController(EstatisticaService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Estatistica> getEstatisticas(@RequestParam(defaultValue = "60") int interval){
        return ResponseEntity.status(HttpStatus.OK).body(service.getStats(interval));
    }
}
