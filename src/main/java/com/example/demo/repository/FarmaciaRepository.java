
package com.example.demo.repository;

import com.example.demo.model.Farmacia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.yuequan.jpa.soft.delete.repository.SoftDelete;

/*
 
  @author Alcídia Cristina
 */
@SoftDelete
public interface FarmaciaRepository extends JpaRepository<Farmacia, Long> {

    public Farmacia findByLoginAndSenha(@Param("login")String email,@Param("senha")String senha);
    //  update farmacia set removed_at=? where id=1;
    
    
    public Farmacia findByEmail(@Param("email")String email);
    
    
    
   
}
