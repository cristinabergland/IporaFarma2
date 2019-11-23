
package com.example.demo.repository;

import com.example.demo.model.Categoria;
import com.example.demo.model.Medicamentos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
/*
 
  @author Alcídia Cristina
 */
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
    
    //public List<Categoria> findByCategoriaOrderByPrecoAsc(@Param("Categoria")String cat); 
 
    
}
