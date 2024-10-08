package com.example.demo1.services;

import java.util.*;

import com.example.demo1.entity.*;

public interface ServiceInter {
    Optional<Ministerio> findMinisterio(String nombre);

    Optional<Osde> findOsde(String nombre);

    Optional<Entidad> findEntidad(String nombre);

    Optional<Municipio> findMunicipio(String nombre);
}
