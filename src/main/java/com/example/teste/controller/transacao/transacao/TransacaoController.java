package com.example.teste.controller.transacao.transacao;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService service;

    public TransacaoController(TransacaoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Transacao> postTransacao(@RequestBody @Valid Transacao transacao){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addTransacao(transacao));
    }
    @GetMapping
    public ResponseEntity<List<Transacao>> getTransacao(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getTransacoes());
    }
    @DeleteMapping
    public ResponseEntity<?> deleteTransacao(){
        service.clearTransacoes();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
