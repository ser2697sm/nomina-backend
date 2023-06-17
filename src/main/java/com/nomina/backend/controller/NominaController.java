package com.nomina.backend.controller;

import com.nomina.backend.model.entity.Nomina;
import com.nomina.backend.services.NominaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/nomina")
public class NominaController {

    @Autowired
    private NominaService nominaService;

    private ArrayList<Nomina> verTodasNominas() {
        return (ArrayList<Nomina>) nominaService.listarNominas();
    }
    @PostMapping
    private Nomina insertarNomina(@RequestBody Nomina nomina) {
        return nominaService.guardarActualizarNomina(nomina);
    }
}
