package com.example.teste.controller.transacao;

import java.util.ArrayList;
import java.util.List;

public class TransacaoRepository {
    public static List<Transacao> transacoes = new ArrayList<>();

    public void save(Transacao transacao){
        transacoes.add(transacao);
    }

}
