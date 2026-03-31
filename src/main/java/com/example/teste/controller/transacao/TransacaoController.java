package com.example.teste.controller.transacao;


import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {
    //List<Transacao> transacoes = new ArrayList<>();
    TransacaoService Service;

    @PostMapping
    public ResponseEntity<?> postTransacao(@RequestBody @Valid Transacao transacao){
        Service.addTransacao(transacao);
        return ResponseEntity.status(201).build();
    }
    @GetMapping
    public ResponseEntity<List<Transacao>> getTransacao(@RequestParam(value = "id") String id){
        return ResponseEntity.status(200).body(transacoes);
    }
    @DeleteMapping
    public ResponseEntity<?> deleteTransacao(){
        transacoes.clear();
        return ResponseEntity.status(200).build();
    }
}
