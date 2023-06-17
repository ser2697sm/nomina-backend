package com.nomina.backend.services;

import com.nomina.backend.model.entity.Nomina;
import com.nomina.backend.repository.NominaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


@Service
public class NominaService {
    @Autowired
    private NominaRepository nominaRepository;

    //Listar Nominas
    public ArrayList<Nomina> listarNominas() {
        return (ArrayList<Nomina>) nominaRepository.findAll();
    }


    public Nomina guardarActualizarNomina(Nomina nomina) {

        return nominaRepository.save(nomina);
    }

    public void eliminarNomina(Long id) {
        nominaRepository.deleteById(id);
    }
}
