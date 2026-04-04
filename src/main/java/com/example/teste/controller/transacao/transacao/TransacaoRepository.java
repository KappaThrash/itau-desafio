package com.example.teste.controller.transacao.transacao;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransacaoRepository {
    private final static List<Transacao> transacoes = new ArrayList<>();

    public void save(Transacao transacao){
        transacoes.add(transacao);
    }

    public void clear(){
        transacoes.clear();
    }

    public List<Transacao> getList(){
        return new ArrayList<>(transacoes);
    }

}
