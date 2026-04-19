package com.example.teste.controller.transacao.transacao;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transacao {
    @NotNull
    private BigDecimal valor;
    @NotNull
    private OffsetDateTime dataHora;
}
