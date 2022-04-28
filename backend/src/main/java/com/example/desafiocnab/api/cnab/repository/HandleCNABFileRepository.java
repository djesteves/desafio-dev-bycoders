package com.example.desafiocnab.api.cnab.repository;

import com.example.desafiocnab.api.cnab.entity.CNAB;

import com.example.desafiocnab.api.cnab.entity.CNABResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface HandleCNABFileRepository extends JpaRepository<CNAB, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO temp_calc (nome_loja,"
            + "             cpf,"
            + "             dono_loja,"
            + "             valor,"
            + "             tipo_pagamento)"
            + " SELECT cnab.nome_loja,"
            + "       cnab.cpf,"
            + "       cnab.dono_loja,"
            + "       cnab.valor AS valor,"
            + "       CASE"
            + "         WHEN cnab.tipo = '1' THEN 1"
            + "         WHEN cnab.tipo = '2' THEN -1"
            + "         WHEN cnab.tipo = '3' THEN -1"
            + "         WHEN cnab.tipo = '4' THEN 1"
            + "         WHEN cnab.tipo = '5' THEN 1"
            + "         WHEN cnab.tipo = '6' THEN 1"
            + "         WHEN cnab.tipo = '7' THEN 1"
            + "         WHEN cnab.tipo = '8' THEN 1"
            + "         WHEN cnab.tipo = '9' THEN -1"
            + "       end        AS tipo_pagamento"
            + " FROM   cnab cnab", nativeQuery = true)
    void saveTotalLoja();

    @Query(value = " SELECT nome_loja,"
            + "       cpf,"
            + "       dono_loja,"
            + "       Sum(valor * tipo_pagamento) AS valor"
            + " FROM   temp_calc "
            + " GROUP  BY nome_loja,"
            + "          cpf,"
            + "          dono_loja  ", nativeQuery = true)
    List<CNABResponse> totalLoja();


}
