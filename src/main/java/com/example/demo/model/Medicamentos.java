/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


/**
 *
 * @author Alcidia Cristina
 */
@Entity
//@SQLDelete(sql = "UPDATE medicamentos SET ativo_fk = ? WHERE id= ?")
//@Where(clause = "ativo=1 ")
//@Where(clause = "ativo=1 and Farmacia f f.ativo =1")
public class Medicamentos implements Serializable{
    
    private Long id;
    private String nome;
    private String principioAtivo;
    private String concentracao;
    private String formaFarmaceutica;
    private int registroAnvisa;
    private String detentorRegistro;
    private Farmacia farmacia;
    private List<Categoria> categoria;
    private double preco;
    private Long quantidade;
    private List<Imagem> imagens;
    private Date removedAt;
   // private int ativo = 1;
   

    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
    
    public String getPrincipioAtivo() {
        return principioAtivo;
    }

    public void setPrincipioAtivo(String principioAtivo) {
        this.principioAtivo = principioAtivo;
    }

    public String getConcentracao() {
        return concentracao;
    }

    public void setConcentracao(String concentracao) {
        this.concentracao = concentracao;
    }

    public String getFormaFarmaceutica() {
        return formaFarmaceutica;
    }

    public void setFormaFarmaceutica(String formaFarmaceutica) {
        this.formaFarmaceutica = formaFarmaceutica;
    }

    public int getRegistroAnvisa() {
        return registroAnvisa;
    }

    public void setRegistroAnvisa(int registroAnvisa) {
        this.registroAnvisa = registroAnvisa;
    }

    public String getDetentorRegistro() {
        return detentorRegistro;
    }

    public void setDetentorRegistro(String detentorRegistro) {
        this.detentorRegistro = detentorRegistro;
    }
    
    @OneToMany(cascade = {CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "medicamento_id")
    public List<Imagem> getImagens() {
        return imagens;
    }

    public void setImagens(List<Imagem> imagens) {
        this.imagens = imagens;
    }

    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.REMOVE})
    public List<Categoria> getCategoria() {
        return categoria;
    }

    public void setCategoria(List<Categoria> categoria) {
        this.categoria = categoria;
    }

    @OneToOne(cascade={CascadeType.REFRESH, CascadeType.REMOVE })
   // @Where(clause="ativo <> 0")
    public Farmacia getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
    }
    
    @Column(name = "removed_at")
    public Date getRemovedAt() {
        return removedAt;
    }

    public void setRemovedAt(Date removedAt) {
        this.removedAt = removedAt;
    }
     
}
