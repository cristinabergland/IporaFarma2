package com.example.demo.controller;

import com.example.demo.service.FarmaciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Farmacia;
import com.example.demo.config.Autenticacao;
import com.example.demo.model.Endereco;
import com.example.demo.model.FarmaciaDTO;
import com.example.demo.model.Medicamentos;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import static java.nio.file.Files.list;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 
  @author Alcídia Cristina
 */
@RestController
@RequestMapping(value = "/administrador")
public class FarmaciaController {

    @Autowired
    FarmaciaService admnistradorService;
    
    @Autowired
    public JavaMailSender emailSender;

    @RequestMapping(method = RequestMethod.POST, value = "/autenticar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity autenticar(@RequestBody Farmacia adm) {
   
        Farmacia admAuth = admnistradorService.autenticarAdministrador(adm);

        if (admAuth == null || admAuth.getLogin().equals("") || admAuth.getSenha().equals("")) {
            return new ResponseEntity<>(admAuth, HttpStatus.FORBIDDEN);
        }

        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setSubject(admAuth.getLogin());
        jwtBuilder.setId(""+admAuth.getId());
        jwtBuilder.claim("adm", true);
        jwtBuilder.setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000));
        jwtBuilder.signWith(Autenticacao.key);

        String token = jwtBuilder.compact();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);

        return new ResponseEntity<>(headers, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/cadastrarfarmacia", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity cadastrarAdministrador(@RequestBody Farmacia adm) {

        admnistradorService.cadastrarAdministrador(adm);

        return new ResponseEntity(HttpStatus.CREATED);

    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/recuperarsenha", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity recuperarsenha(@RequestBody Farmacia adm) {

        Farmacia farmacia= admnistradorService.buscaporemail(adm.getEmail());

        if(farmacia != null){
            String novasenha = "";
           
            for(int i= 0;i<6; i++){               
                novasenha= novasenha+ new Random().nextInt(9);
            }
            System.out.println("nova senha: "+novasenha);
            farmacia.setSenha(novasenha);
            admnistradorService.editarAdministrador(farmacia);
            //mandar email  
          
            SimpleMailMessage message = new SimpleMailMessage(); 
            message.setTo(farmacia.getEmail()); 
            message.setSubject("recuperação de senha"); 
            message.setText(novasenha);
            emailSender.send(message);

            System.out.println("email enviado");
            
            return new ResponseEntity(HttpStatus.CREATED);
        }else{
            System.out.println("email não pertence a nenhuma conta"); 
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
        
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    ResponseEntity removerAdministrador(@RequestHeader HttpHeaders headers) {
        
       Farmacia farmacia;
        
       try {
            farmacia = admnistradorService.buscaFarmaciaToken(headers);
            
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        admnistradorService.removerAdministrador(farmacia.getId());

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/edita", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity editarAdministrador(@RequestHeader HttpHeaders headers, @RequestBody Farmacia adm) {

        Farmacia farmacia;
        
        try {
            farmacia = admnistradorService.buscaFarmaciaToken(headers);
            
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        // Alterando endereco
        Endereco endereco;
       
        endereco = adm.getEndereco();
        endereco.setId(farmacia.getEndereco().getId());
       
        adm.setEndereco(endereco);
        adm.setId(farmacia.getId());
        adm.setEmail(farmacia.getEmail());
        adm.setLogin(farmacia.getLogin());
        adm.setSenha(farmacia.getSenha());
        
        admnistradorService.editarAdministrador(adm);

        return new ResponseEntity(HttpStatus.CREATED);
    }
   
    @RequestMapping(method = RequestMethod.GET, value = "/listarprodutos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Medicamentos> mostrarProduto(@RequestHeader HttpHeaders headers){
        
        Farmacia adm;
        
        try {
         
            adm = admnistradorService.buscaFarmaciaToken(headers);
            
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
       
        List<Medicamentos> produtos = admnistradorService.buscaMedicamentosInclusiveRemovidos(adm.getId());
        
        return new ResponseEntity(produtos, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/administrador", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Farmacia> mostraAdministrador(@RequestHeader HttpHeaders headers) {
        
        Farmacia farmacia;
        
        try{
            farmacia = admnistradorService.buscaFarmaciaToken(headers);     
        }catch(Exception ex) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(farmacia, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/administradores", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<FarmaciaDTO>> mostraTodosAdministrador() {

        List<Farmacia> adm;
        List<FarmaciaDTO> listDTO;
        
        try {
            
            adm = admnistradorService.buscaTodos();
            listDTO = new ArrayList<>(adm.size());
            
            for (Farmacia f : adm) {
                listDTO.add(new FarmaciaDTO(f));
            }

        } catch (NoSuchElementException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(listDTO, HttpStatus.OK);  
    }   
}