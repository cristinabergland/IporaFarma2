/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model;

/**
 *
 * @author Cristina
 */



public class FarmaciaDTO {
    

    private Long id;
    private Endereco endereco;
    private String nome;
    private String telefone;
    private String cnpj;
    private String email;

//Getters and Setters

    public FarmaciaDTO(Farmacia farmacia) {
        this.id = farmacia.getId();
        this.endereco = farmacia.getEndereco();
        this.nome = farmacia.getNome();
        this.telefone = farmacia.getTelefone();
        this.cnpj = farmacia.getCnpj();
        this.email = farmacia.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    
    
    
    
}


