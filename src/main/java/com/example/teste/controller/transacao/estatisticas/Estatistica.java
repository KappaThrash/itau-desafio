package com.example.teste.controller.transacao.estatisticas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Estatistica {
    double count;
    double sum;
    double avg;
    double min;
    double max;
}
