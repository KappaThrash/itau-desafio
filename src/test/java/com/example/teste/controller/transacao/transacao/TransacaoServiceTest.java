package com.example.teste.controller.transacao.transacao;

import com.example.teste.controller.transacao.exceptions.InvalidDateException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransacaoServiceTest {

    @Mock
    TransacaoRepository transacaoRepository;

    @InjectMocks
    TransacaoService transacaoService;

    @Test
    void addTransacao() {
        var transacao = new Transacao(new BigDecimal(100), OffsetDateTime.now().minusSeconds(10));

        when(transacaoRepository.save(transacao)).thenReturn(transacao);

        assertEquals(transacaoService.addTransacao(transacao), transacao);
    }

    @Test
    void addTransacaoShouldThrowInvalidDateException() {
        var transacao = new Transacao(new BigDecimal(100), OffsetDateTime.now().plusMinutes(1));

        assertThrows(InvalidDateException.class, () -> transacaoService.addTransacao(transacao));
    }

    @Test
    void addTransacaoShouldThrowIllegalArgumentException() {
        var transacao = new Transacao(new BigDecimal(-1), OffsetDateTime.now().minusSeconds(10));

        assertThrows(IllegalArgumentException.class, () -> transacaoService.addTransacao(transacao));
    }
}