package com.example.teste.controller.transacao.transacao;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {
    //List<Transacao> transacoes = new ArrayList<>();


    private final TransacaoService service;

    public TransacaoController(TransacaoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> postTransacao(@RequestBody @Valid Transacao transacao){
        service.addTransacao(transacao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping
    public ResponseEntity<List<Transacao>> getTransacao(){
        return ResponseEntity.status(200).body(service.getTransacoes());
    }
    @DeleteMapping
    public ResponseEntity<?> deleteTransacao(){
        service.clearTransacoes();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
