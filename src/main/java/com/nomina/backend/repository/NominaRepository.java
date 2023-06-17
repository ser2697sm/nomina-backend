package com.nomina.backend.repository;

import com.nomina.backend.model.entity.Nomina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface NominaRepository extends JpaRepository<Nomina,Long> {

}
