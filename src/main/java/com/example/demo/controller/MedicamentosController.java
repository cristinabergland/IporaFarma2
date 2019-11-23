package com.example.demo.controller;

import ch.qos.logback.core.util.OptionHelper;
import com.example.demo.model.Categoria;
import com.example.demo.model.Farmacia;
import com.example.demo.model.Imagem;
import com.example.demo.model.Medicamentos;
import com.example.demo.service.CategoriaService;
import com.example.demo.service.FarmaciaService;
import com.example.demo.service.MedicamentosService;
import java.util.ArrayList;
import java.util.List;
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

/*
 
  @author Alcídia Cristina
 */

@RestController
@RequestMapping(value = "/")
public class MedicamentosController {
    
    @Autowired
    private MedicamentosService produtoService;
    
    @Autowired
    private FarmaciaService farmaciaService;
    
    @Autowired
    private CategoriaService categoriaService;
    
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/adminAut/produto")
    public ResponseEntity cadastrarProduto(@RequestHeader HttpHeaders headers, @RequestBody Medicamentos produto){
        
        //Obter atraves do token a farmacia que esta cadastrando.
        //produto.setFarmacia(farmaciaRecuperadaAtravésDoToken)
        
        List<Categoria> categorias;
        
        try {
            produto.setFarmacia(farmaciaService.buscaFarmaciaToken(headers));
            
            categorias = produto.getCategoria();
            
            List<Categoria> listaCategorias = new ArrayList<>();
            for(int i = 0; i < categorias.size(); i++) {
               listaCategorias.add( categoriaService.buscarCategoriaId(categorias.get(i).getId()) );
            }
            
            produto.setCategoria(listaCategorias);
            
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        produtoService.cadastrarMedicamento(produto);
        
        return new ResponseEntity(HttpStatus.CREATED);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/produto/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Medicamentos> mostrarProduto(@PathVariable Long id){
            
        Medicamentos produto = produtoService.consultarMedicamento(id);
        
        return new ResponseEntity(produto, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/produto", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Medicamentos> mostrarTodosProduto(){
        List<Medicamentos> produtos = produtoService.buscaTodosProdutos();
        
        return new ResponseEntity(produtos, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/menor/produto", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<Medicamentos> ordenarPorMenorPreco(String nome, String principioAtivo){
        List<Medicamentos> produtos = produtoService.ordenarPorMenorPreco(nome, principioAtivo);
        
        return new ResponseEntity(produtos, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/adminAut/produto")
    public ResponseEntity editaProduto(@RequestBody Medicamentos produto, @RequestHeader HttpHeaders headers){
        
        Medicamentos medicamento;
        try{
            produto.setFarmacia(farmaciaService.buscaFarmaciaToken(headers));
            
            medicamento = produtoService.consultarMedicamento(produto.getId());
            List<Imagem> imagens = new ArrayList<>();
            imagens = medicamento.getImagens();
            
            if(produto.getImagens() == null || produto.getImagens().isEmpty()) {
                
                if(imagens != null && !imagens.isEmpty()) {
                    produto.setImagens(imagens);
                }
            }
            
        }catch(Exception ex) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        produtoService.alterarMedicamento(produto);
        
        return new ResponseEntity(HttpStatus.OK);
    } 
    
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/adminAut/ativarproduto")
    public ResponseEntity ativarMedicamento(@RequestBody Medicamentos medicamento,@RequestHeader HttpHeaders headers){
        
        
        Farmacia farmacia;
        try{
            
            farmacia = farmaciaService.buscaFarmaciaToken(headers);
            
        }catch(Exception ex) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        produtoService.alterarMedicamento(medicamento);
        
        return new ResponseEntity(HttpStatus.OK);
    } 
    
    @RequestMapping(method = RequestMethod.DELETE,consumes = MediaType.APPLICATION_JSON_VALUE, value = "/adminAut/produto/{id}")
    public ResponseEntity excluirProduto(@PathVariable Long id, @RequestHeader HttpHeaders headers){
        
        Farmacia adm;
          try {
         
            adm = farmaciaService.buscaFarmaciaToken(headers);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
          
        produtoService.desabilitarMedicamento(id);
        
        return new ResponseEntity(HttpStatus.OK);
    }
}
