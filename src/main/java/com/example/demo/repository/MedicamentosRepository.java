
package com.example.demo.repository;

import com.example.demo.model.Categoria;
import com.example.demo.model.Farmacia;
import com.example.demo.model.Medicamentos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.yuequan.jpa.soft.delete.repository.SoftDelete;

/*
 
  @author Alcídia Cristina
 */
@SoftDelete
public interface MedicamentosRepository extends JpaRepository<Medicamentos, Long> {
    public List<Medicamentos> findByCategoria(Categoria categoria);
    
    
    public List<Medicamentos> findByNomeOrPrincipioAtivoOrderByPrecoAsc(@Param("nome")String nome,@Param("principioAtivo")String principioAtivo);
 
     @Query("select m from Medicamentos m where m.farmacia.id= :idFarmacia")
     public  List<Medicamentos> FindAllEvenRemoved(@Param ("idFarmacia")Long idFarmacia);
}
