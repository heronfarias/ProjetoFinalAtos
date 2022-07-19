package com.financial.financial.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financial.financial.model.entities.Passivo;

public interface PassivoRepository extends JpaRepository <Passivo, Integer>{
    
}
