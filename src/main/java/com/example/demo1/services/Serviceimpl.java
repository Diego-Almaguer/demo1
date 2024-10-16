package com.example.demo1.services;

import com.example.demo1.entity.*;
import com.example.demo1.repository.MinisterioRepository;

import com.example.demo1.repository.MunicipioRepository;
import com.example.demo1.repository.OsdeRepository;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class Serviceimpl implements ServiceInter {
    @Autowired
    MinisterioRepository ministerioRepository;
    @Autowired
    OsdeRepository osdeRepository;
    @Autowired
    EntidadService entidadService;
    @Autowired
    MunicipioRepository municipioRepository;

    public Optional<Ministerio> findMinisterio(String nombre) {
        if (nombre.length() <= 0 || nombre == null) {
            throw new IllegalArgumentException("nombre es nulo o vacio");
        }
        List<Ministerio> lista = ministerioRepository.findAll();
        for (Ministerio ministerio : lista) {
            if (ministerio.getNombre().equalsIgnoreCase(nombre)) {
                return Optional.of(ministerio);
            }
        }
        throw new EntityNotFoundException("no se encontro nimgun Ministerio con nombre: " + nombre);
    }

    public Optional<Osde> findOsde(String nombre) {
        if (nombre.length() <= 0 || nombre == null) {
            throw new IllegalArgumentException("nombre es nulo o vacio");
        }
        List<Osde> lista = osdeRepository.findAll();
        for (Osde osde : lista) {
            if (osde.getNombre().equalsIgnoreCase(nombre)) {
                return Optional.of(osde);
            }
        }
        throw new EntityNotFoundException("no se encontro nimgun Ministerio con nombre: " + nombre);

    }

    public Optional<Entidad> findEntidad(String nombre) {
        if (nombre.length() <= 0 || nombre == null) {
            throw new IllegalArgumentException("nombre es nulo o vacio");
        }
        List<Entidad> lista = (List<Entidad>) entidadService.findAll();
        for (Entidad entidad : lista) {
            if (entidad.getNombre().equalsIgnoreCase(nombre)) {
                return Optional.of(entidad);
            }
        }
        throw new EntityNotFoundException("no se encontro nimgun Ministerio con nombre: " + nombre);

    }

    public Optional<Municipio> findMunicipio(String nombre) {
        if (nombre.length() <= 0 || nombre == null) {
            throw new IllegalArgumentException("nombre es nulo o vacio");
        }
        List<Municipio> lista = municipioRepository.findAll();
        for (Municipio municipio : lista) {
            if (municipio.getNombre().equalsIgnoreCase(nombre)) {
                return Optional.of(municipio);
            }
        }
        throw new EntityNotFoundException("no se encontro nimgun Ministerio con nombre: " + nombre);

    }
}
