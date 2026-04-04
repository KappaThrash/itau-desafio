package com.example.teste.controller.transacao.transacao;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class Transacao {
    @NotNull
//    @PositiveOrZero(message = "Valor must be greater or equal to zero")
    private BigDecimal valor;
    @NotNull
    private OffsetDateTime dataHora;

    public Transacao(BigDecimal valor, OffsetDateTime dataHora){
        this.valor = valor;
        this.dataHora = dataHora;
    }

}
