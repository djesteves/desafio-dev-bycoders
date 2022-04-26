package com.example.desafiocnab.api.cnab.repository;

import com.example.desafiocnab.api.cnab.entity.CNAB;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HandleCNABFileRepository extends JpaRepository <CNAB,Long> {
    
}
