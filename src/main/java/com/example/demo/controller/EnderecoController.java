/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.model.Endereco;
import com.example.demo.model.Farmacia;
import com.example.demo.service.EnderecoService;
import com.example.demo.service.FarmaciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Cristina
 */
@RestController
public class EnderecoController {
    
    @Autowired
    EnderecoService enderecoservice;
    
    @Autowired
    private FarmaciaService farmaciaService;
    
    
    @RequestMapping(method = RequestMethod.POST, value = "/cadastrarendereco", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity cadastrarEndereco(@RequestBody Endereco end) {
        
        //Obter através do token a farmácia que está cadastrando.
            //produto.setFarmacia(farmaciaRecuperadaAtravésDoToken)

       /* try {
         
            end.
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        */
        
        

        enderecoservice.cadastrarEndereco(end);

        return new ResponseEntity(HttpStatus.CREATED);

    }
    
    
      @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/editaendereco")
    public ResponseEntity editarEndereco(@RequestBody Endereco end){
        enderecoservice.editarEndereco(end);
        
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/endereco/{id}")
    public ResponseEntity removerEndereco(@PathVariable Long id){
        
        System.out.println("id do produto: " + id);
        enderecoservice.removerEndereco(id);
        
        return new ResponseEntity(HttpStatus.OK);
    }
}
    
    
    
    
