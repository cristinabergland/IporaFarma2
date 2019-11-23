/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.model.Categoria;
import com.example.demo.model.Medicamentos;
import com.example.demo.repository.CategoriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.MedicamentosRepository;

/**
 *
 * @author Alcídia Cristina
 */
@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    MedicamentosRepository produtoRepository;

    public void cadastrarCategoria(Categoria cat) {
        categoriaRepository.save(cat);
    }

    public Categoria editarCategoria(Categoria cat) {
        return categoriaRepository.save(cat);
    }

    public void excluirCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }

    public Categoria buscarCategoriaId(Long id) {
        return categoriaRepository.findById(id).get();
    }
    
    public List<Medicamentos> buscaTodosProdutosCategoria(Categoria cat) {
        return produtoRepository.findByCategoria(cat);
    }

    public List<Categoria> buscaTodasCategorias(){
        return categoriaRepository.findAll();
    }
    


}
