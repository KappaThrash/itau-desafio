package com.example.teste.controller.transacao;

import com.example.teste.controller.transacao.exceptions.InvalidDateException;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class TransacaoService {

    private TransacaoRepository TransacaoRepository;
    private OffsetDateTime now = OffsetDateTime.now();

    public void addTransacao( Transacao transacao ){
        if (transacao.getDataHora().isAfter(now)){
            throw new InvalidDateException("dataHora invalido, pois está no futuro");
        }
        TransacaoRepository.save(transacao);
    }
}
