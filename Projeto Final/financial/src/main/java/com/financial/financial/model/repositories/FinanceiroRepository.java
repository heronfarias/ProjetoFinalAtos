package com.financial.financial.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financial.financial.model.entities.Financeiro;

public interface FinanceiroRepository extends JpaRepository<Financeiro, Integer>{

        List<Financeiro> findAllByTipo(Boolean tipo);

        List<Financeiro> findAllByTipo(int i);
}

