package com.example.teste.controller.transacao.estatisticas;

import com.example.teste.controller.transacao.transacao.Transacao;
import com.example.teste.controller.transacao.transacao.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
public class EstatisticaService {
    private TransacaoRepository rep;

    public EstatisticaService(TransacaoRepository rep){
        this.rep = rep;
    }


    public Estatistica getStats(int Interval){
        List<Transacao> transacaoList = rep.getList();
        DoubleSummaryStatistics summary = new DoubleSummaryStatistics();

        for( Transacao transacoes : transacaoList ){
            if(transacoes.getDataHora().isAfter(OffsetDateTime.now().minusSeconds(Interval))){
                summary.accept(transacoes.getValor().doubleValue());
            }
        }

        return new Estatistica(summary.getCount(),
                summary.getSum(),summary.getAverage(),
                summary.getMin(),summary.getMax());
    }
}
