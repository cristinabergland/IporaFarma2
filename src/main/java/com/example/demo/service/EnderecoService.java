/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.model.Endereco;
import com.example.demo.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cristina
 */
@Service
public class EnderecoService {
    
    @Autowired 
    EnderecoRepository enderecorepository;
    
     public void cadastrarEndereco(Endereco end) {
        enderecorepository.save(end);
    }

    public void editarEndereco(Endereco end) {
        enderecorepository.save(end);
    }

    public void removerEndereco(Long id) {
        enderecorepository.deleteById(id);
    }

    
}
