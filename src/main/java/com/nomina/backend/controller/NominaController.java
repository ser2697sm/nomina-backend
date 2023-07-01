package com.nomina.backend.controller;

import com.nomina.backend.model.entity.Nomina;
import com.nomina.backend.services.NominaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/nomina")
public class NominaController {

    @Autowired
    private NominaService nominaService;

    @CrossOrigin()
    @GetMapping
    private ArrayList<Nomina> verTodasNominas() {
        return (ArrayList<Nomina>) nominaService.listarNominas();
    }
    @PostMapping
    private Nomina insertarNomina(@RequestParam("UbicArchivo") MultipartFile file,
                                  @RequestParam("mes") String mes,
                                  @RequestParam("anio") String anio,
                                  @RequestParam("salario") Integer salario) throws Exception {

      Nomina nomina = new Nomina();

        nomina.setMes(mes.toString());
        nomina.setAnio(Integer.valueOf(anio.toString()));
        nomina.setSalario(Integer.valueOf(salario));
        nomina.setUbicNomina(handleFileUpload(file));

        return nominaService.guardarActualizarNomina(nomina);
    }

    public String handleFileUpload(MultipartFile file) throws Exception {
        try {

            byte[] bytes = file.getBytes();
            String fileOriginalName = file.getOriginalFilename();

            long fileSize = file.getSize();
            long maxFileSize = 5 * 1024 * 1024;

            if(fileSize > maxFileSize) {
                return "File size must be less then or equal 5 MB";
            }

            if(!fileOriginalName.endsWith(".pdf")) {
                return "Only pdf files are allowed!";
            }

            //para pillar la extension del archivo
            String fileExtension = fileOriginalName.substring(fileOriginalName.lastIndexOf("."));

            //para tener el archivo junto
            String newFileName = fileOriginalName;

            File folder = new File("src/main/resources/pdfs/");

            //para crear ña carpeta en caso de que no exista
            if(!folder.exists()) {
                folder.mkdirs();
            }

            Path path= Paths.get("src/main/resources/pdfs/" + newFileName);

            Files.write(path,bytes);

            return newFileName;

        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
