package com.financial.financial.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.financial.financial.model.entities.Financeiro;
import com.financial.financial.model.repositories.FinanceiroRepository;

@RestController
@RequestMapping("/api/financeiro")
public class FinanceiroController {
    @Autowired
    private FinanceiroRepository financeiroRepository;

    @PostMapping
    public @ResponseBody Financeiro novoFinanceiro(@RequestBody Financeiro financeiro) {
        financeiroRepository.save(financeiro);
        return financeiro;
    }

    @GetMapping("/passivo")
    public List<Financeiro> findAllPassivo(){
        return financeiroRepository.findAllByTipo(0);
    }

    @GetMapping("/ativo")
    public List<Financeiro> findAllAtivo(){
        return financeiroRepository.findAllByTipo(1);
    }

    @GetMapping
    public List<Financeiro> obterFinanceiro(){
        return financeiroRepository.findAll();
    }
    

    @GetMapping(path="/{id}")
    public Optional<Financeiro> obterFinanceiroPorId(@PathVariable int id){
        return financeiroRepository.findById(id);
    }

    @PutMapping
    public Financeiro alterarFinanceiro(Financeiro financeiro){
        return financeiroRepository.save(financeiro);
    }

    @DeleteMapping(path ="/{id}")
    public void ExcluirFinanceiro(@PathVariable int id){
        financeiroRepository.deleteById(id);
    }

    @GetMapping(path = "/all")
    public List<Financeiro> listAll() {
        return financeiroRepository.findAll();
    }
}
