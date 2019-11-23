/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Alcidia Cristina
 */
@Entity
//@SQLDelete(sql = "UPDATE farmacia SET ativo = 0 WHERE id= ?")
//@Where(clause = "ativo=1")
public class Farmacia implements Serializable{

    private Long id;
    private String login;
    private String senha;
    private Endereco endereco;
    private String nome;
    private String telefone;
    private String cnpj;
    private String email;
    private Date removedAt;
    // Nova coluna para o banco, usado para marcar se a farmacia está ativa ou não
    //private int ativo = 1;
    
 
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @JsonProperty(access = Access.WRITE_ONLY)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty(access = Access.WRITE_ONLY)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @JsonProperty(access = Access.WRITE_ONLY)
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    //@JsonIgnore
    @OneToOne(cascade ={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

   
    
    @Column(name = "removed_at")
    public Date getRemovedAt() {
        return removedAt;
    }

    public void setRemovedAt(Date removedAt) {
        this.removedAt = removedAt;
    }
     
     
     
    

   

    
  

}
