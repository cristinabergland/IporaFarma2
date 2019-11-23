package com.example.demo.controller;

import com.example.demo.model.Imagem;
import com.example.demo.model.Medicamentos;
import com.example.demo.service.ImagemService;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/*
 
  @author Alcídia Cristina
 */
@RestController
@RequestMapping(value = "/imagem")
public class ImagemController {

    @Autowired
    ImagemService imagemService;

    @RequestMapping(value = "/admin/addimgprod/{id}", method = RequestMethod.POST)
    public ResponseEntity addImagens(
            @PathVariable Long id,
            @RequestPart(value = "file", required = false) MultipartFile[] files
    ) {

        Medicamentos p = new Medicamentos();
        p.setId(id);

        for (MultipartFile f : files) {
            
            try {
                imagemService.storeImagem(f, p);
            } catch (IOException e) {
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<Resource> getImgProd(@PathVariable Long id) {
        Resource resource;

        try {
            resource = imagemService.carregaImagemId(id);
        } catch (NoSuchElementException | FileNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(resource, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    ResponseEntity removerImagem(@PathVariable Long id) {

        imagemService.excluirImagem(id);

        return new ResponseEntity(HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = "/editaimagem/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity editarAdministrador(@PathVariable Imagem img) {

        imagemService.editarImagem(img);

        return new ResponseEntity(HttpStatus.CREATED);
    }
}