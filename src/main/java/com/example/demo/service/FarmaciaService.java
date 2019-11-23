/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.config.Autenticacao;
import com.example.demo.model.Farmacia;
import com.example.demo.model.FarmaciaDTO;
import com.example.demo.model.Medicamentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.FarmaciaRepository;
import com.example.demo.repository.MedicamentosRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.annotations.Where;
import static org.springframework.data.jpa.domain.Specification.where;
import org.springframework.http.HttpHeaders;

/**
 *
 * @author Alcídia Cristina
 */
@Service
public class FarmaciaService {

    @Autowired
    FarmaciaRepository administradorRepository;
    
     @Autowired
     MedicamentosRepository produtoRepository;

    public FarmaciaService() {
    }

    public Farmacia autenticarAdministrador(Farmacia adm) {
        return administradorRepository.findByLoginAndSenha(adm.getLogin(), adm.getSenha());

    }

    public void cadastrarAdministrador(Farmacia adm) {
        administradorRepository.save(adm);
    }

    public void editarAdministrador(Farmacia adm) {
        administradorRepository.save(adm);
      
    }
    
    public void removerAdministrador(Long id) {
        administradorRepository.deleteById(id);
      
    }

    public Farmacia buscaAdministrador(Long id) {
        return administradorRepository.findById(id).get();
    }

    public java.util.List<Farmacia> buscaTodos() {

        return  administradorRepository.findAll();

   
    }

    /*
	 * Método responsavel por fazer o delete da farmacia,
	 * Recebe um objeto do tipo Farmacia e não o ID
     */
 /* public void desabilitarFarmacia (Farmacia farmacia) {
        administradorRepository.delete(farmacia);
    }*/
    
    
    public Farmacia buscaporemail(String email) {
        return administradorRepository.findByEmail(email);
    }
   
    
    public Farmacia buscaFarmaciaToken(HttpHeaders header) throws Exception {
        try{
            String token;
            
            token = header.get("Authorization").get(0);
            
            if (token.isEmpty()){
                
                throw new Exception("token vazio");
                
            }
             token = token.substring(7);
           
             Claims c = Jwts.parser()
                     .setSigningKey(Autenticacao.key)
                     .parseClaimsJws(token)
                     .getBody();
             
             Long idFarmacia = Long.parseLong(c.getId().toString());
             
             Farmacia farmacia = buscaAdministrador(idFarmacia);
             if (farmacia==null){
                 
                 throw new Exception();
             }
             return farmacia;
             
        }
        
        catch(Exception e){
            
            
            System.out.println("Não foi possivel obter o token");
            throw new Exception("aaa");
    }
    
  
    
}
    
    
     public List<Medicamentos> buscaMedicamentosInclusiveRemovidos(Long id){
         return produtoRepository.FindAllEvenRemoved(id);
     }
}