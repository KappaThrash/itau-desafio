package com.example.teste.controller.transacao.transacao;

import com.example.teste.controller.transacao.exceptions.InvalidDateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Service
public class TransacaoService {

    @Autowired
    private final TransacaoRepository transacaoRepository;

    private final OffsetDateTime now = OffsetDateTime.now();

    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    public Transacao addTransacao(Transacao transacao){
        if (transacao.getDataHora().isAfter(now)){
            throw new InvalidDateException("dataHora invalido, pois está no futuro");
        }
        if(transacao.getValor().compareTo(new BigDecimal(0)) < 0 ) {
            throw new IllegalArgumentException("Valor negativo");
        }

        return transacaoRepository.save(transacao);

    }
    public void clearTransacoes(){
        transacaoRepository.clear();
    }

    public List<Transacao> getTransacoes(){

        return transacaoRepository.getList();
    }
}
