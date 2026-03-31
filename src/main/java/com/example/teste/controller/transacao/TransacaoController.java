package com.example.teste.controller.transacao;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {
    //List<Transacao> transacoes = new ArrayList<>();


    private TransacaoService Service;

    @PostMapping
    public ResponseEntity<?> postTransacao(@RequestBody @Valid Transacao transacao){
        Service.addTransacao(transacao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping
    public ResponseEntity<List<Transacao>> getTransacao(){
        return ResponseEntity.status(200).body(Service.getTransacoes());
    }
    @DeleteMapping
    public ResponseEntity<?> deleteTransacao(){
        Service.clearTransacoes();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
