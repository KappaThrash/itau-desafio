package com.example.teste.controller.transacao;

import com.example.teste.controller.transacao.exceptions.InvalidDateException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class TransacaoService {

    private TransacaoRepository TransacaoRepository;
    private OffsetDateTime now = OffsetDateTime.now();

    public TransacaoService(TransacaoRepository TransacaoRepository) {
        this.TransacaoRepository = TransacaoRepository;
    }

    public void addTransacao( Transacao transacao ){
        if (transacao.getDataHora().isAfter(now)){
            throw new InvalidDateException("dataHora invalido, pois está no futuro");
        }
        TransacaoRepository.save(transacao);
    }
    public void clearTransacoes(){
        TransacaoRepository.clear();
    }

    public List<Transacao> getTransacoes(){

        return TransacaoRepository.getList();
    }
}
