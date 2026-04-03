package com.example.teste.controller.transacao.estatisticas;

import com.example.teste.controller.transacao.Transacao;
import com.example.teste.controller.transacao.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstatisticaService {
    private TransacaoRepository rep;
    Estatistica stat = new Estatistica();


    public Estatistica getStats(){
        List<Transacao> transacaoList = rep.getList();

        for( Transacao transacoes : transacaoList){
            transacoes.getValor().Douib;
        }


        return new Estatistica();
    }
}
