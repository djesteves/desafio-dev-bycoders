package com.example.desafiocnab.repository;

import com.example.desafiocnab.model.CNAB;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HandleCNABFileRepository extends JpaRepository <CNAB,Long> {
    
}
