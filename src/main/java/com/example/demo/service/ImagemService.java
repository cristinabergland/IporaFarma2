
package com.example.demo.service;

import com.example.demo.model.Imagem;
import com.example.demo.model.Medicamentos;
import com.example.demo.repository.ImagemRepository;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/*
 
  @author Alcídia Cristina
 */
@Service
public class ImagemService {

    private final Path fileStorageLocation;

    @Autowired
    private ImagemRepository imagemRepository;

    private ImagemService(FileStorageProperties fsp) {
        this.fileStorageLocation = Paths.get(fsp.getUploadDir()).toAbsolutePath().normalize();
        try {
            Files.createDirectories(fileStorageLocation);
        } catch (IOException e) {
            System.out.println("não foi possível criar o diretorio raiz de uploads" + e);
        }
    }

    public void cadastrarImagem(Imagem img) {
        imagemRepository.save(img);
    }

    public Imagem editarImagem(Imagem img) {
        return imagemRepository.save(img);
    }

    public void excluirImagem(Long id) {
        imagemRepository.deleteById(id);
    }

    public Imagem buscaImagem(Long id) {
        return imagemRepository.findById(id).get();
    }

    private String generatePath() {
        String path;

        LocalDateTime dateTime;
        dateTime = LocalDateTime.now();
        path = "/" + dateTime.getYear()
                + "/" + dateTime.getMonth()
                + "/" + dateTime.getDayOfMonth() + "/";

        return path;
    }

    private String generateUUIDandExtension(MultipartFile file) throws IOException {
        String fullname = file.getOriginalFilename();
        String ext = "";

        int i = fullname.lastIndexOf('.');

        if (i == -1) {
            throw new IOException("Arquivo sem extensão válida");
        }
        if (i >= 0) {
            ext = fullname.substring(i);
        }
        return UUID.randomUUID() + ext;
    }

    public void storeImagem(MultipartFile file, Medicamentos p) throws IOException {
        String relativePath = generatePath() + generateUUIDandExtension(file);
        Path absulutePath;
        absulutePath = Paths.get(
                fileStorageLocation.toString()
                + relativePath).toAbsolutePath().normalize();

        try {
            Files.createDirectories(absulutePath);
            Files.copy(file.getInputStream(), absulutePath, StandardCopyOption.REPLACE_EXISTING);

            Imagem img = new Imagem();
            img.setPath(relativePath);
            img.setMedicamento(p);

            imagemRepository.save(img);

        } catch (IOException e) {
            System.out.println("Erro: " + e);
        }
    }

    public Resource carregaImagemId(Long id) throws FileNotFoundException {
        Imagem img = imagemRepository.findById(id).get();

        try {
            if (img == null) {
                throw new FileNotFoundException("File not found");
            }
            Path imgpath = Paths.get(
                    fileStorageLocation.toString()
                    + img.getPath()).toAbsolutePath().normalize();

            Path fullpath = this.fileStorageLocation.resolve(imgpath).normalize();

            Resource resource = new UrlResource(fullpath.toUri());
            if (resource.exists()) {
                return resource;
            }
        } catch (NoSuchElementException | MalformedURLException e) {
            throw new FileNotFoundException("File not found " + e);
        }
        throw new FileNotFoundException("File not found ");

    }

   

}
