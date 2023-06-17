package com.nomina.backend.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "nominas")
public class Nomina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mes;
    private Integer anio;

    private Integer salario;
    private String ubicNomina;

    public Integer getSalario() {
        return salario;
    }

    public void setSalario(Integer salario) {
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getUbicNomina() {
        return ubicNomina;
    }

    public void setUbicNomina(String ubicNomina) {
        this.ubicNomina = ubicNomina;
    }
}
