package com.financial.financial.controller;

import java.util.List;

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

import com.financial.financial.model.entities.Passivo;
import com.financial.financial.model.repositories.PassivoRepository;

@RestController
@RequestMapping("/api/passivo")
public class PassivoController {
    @Autowired
    private PassivoRepository passivoRepository;

    @PostMapping
    public @ResponseBody Passivo novoPassivo(@RequestBody Passivo passivo){
        passivoRepository.save(passivo);
        return passivo;
    } 

@GetMapping
    public List<Passivo> obterPassivo(){
        return passivoRepository.findAll();
    }
@PutMapping
public Passivo alterarPassivo(@RequestBody Passivo passivo) {
    return passivoRepository.save(passivo);
}

@DeleteMapping(path ="/{id}")
public void ExcluirPassivo(@PathVariable int id){
    passivoRepository.deleteById(id);
}

@GetMapping(path = "/all")
public List<Passivo> listAll() {
    return passivoRepository.findAll();
}

}