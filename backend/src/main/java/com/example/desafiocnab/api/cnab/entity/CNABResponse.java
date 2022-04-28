package com.example.desafiocnab.api.cnab.entity;

import java.math.BigDecimal;

public interface CNABResponse {

    BigDecimal getValor();
    String getCpf();
    String getDono_Loja();
    String getNome_Loja();
}
