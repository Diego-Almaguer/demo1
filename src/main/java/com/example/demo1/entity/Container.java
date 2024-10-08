package com.example.demo1.entity;

import java.io.Serializable;

public class Container implements Serializable {
    private Ministerio ministerio;
    private Osde osde;
    private Entidad entidad;
    private Deficiencia deficiencia;
    private Multa multa;
    private Municipio municipio;

    public Ministerio getMinisterio() {
        return ministerio;
    }

    public void setMinisterio(Ministerio ministerio) {
        this.ministerio = ministerio;
    }

    public Osde getOsde() {
        return osde;
    }

    public void setOsde(Osde osde) {
        this.osde = osde;
    }

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }

    public Deficiencia getDeficiencia() {
        return deficiencia;
    }

    public void setDeficiencia(Deficiencia deficiencia) {
        this.deficiencia = deficiencia;
    }

    public Multa getMulta() {
        return multa;
    }

    public void setMulta(Multa multa) {
        this.multa = multa;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

}
