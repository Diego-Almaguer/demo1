package com.example.demo1.entity;

import java.io.Serializable;

public class Container implements Serializable {
    private Ministerio ministerio;
    private Osde osde;

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

}
