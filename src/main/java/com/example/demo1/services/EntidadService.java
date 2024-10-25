package com.example.demo1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.entity.Entidad;
import com.example.demo1.repository.EntidadRepository;

import java.util.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class EntidadService {
    @Autowired
    EntidadRepository entidadRepository;

    public void save(Entidad entidad) {
        try {
            if (entidad != null) {
                this.entidadRepository.save(entidad);
            } else {
                throw new IllegalArgumentException("User object is null");
            }

        } catch (Exception e) {

            throw new RuntimeException("Failed to save user: " + e.getMessage(), e);
        }

    }

    public Optional<Entidad> getById(Integer id) {
        try {
            if (id != null) {
                return this.entidadRepository.findById(id);
            } else {
                throw new IllegalArgumentException("User id is null");
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to find user : " + e.getMessage(), e);
        }

    }

    public Iterable<Entidad> findAll() {
        try {
            return this.entidadRepository.findAll();

        } catch (Exception e) {
            throw new RuntimeException("Failed to findAll users : " + e.getMessage(), e);
        }

    }

    public void update(Entidad entidad, Integer id) {
        try {
            if (id != null) {
                Optional<Entidad> entidadFind = this.entidadRepository.findById(id);
                if (entidadFind.isEmpty()) {
                    throw new EntityNotFoundException("User not found with ID: " + id);
                } else {
                    Entidad entidadUpdate = entidadFind.get();
                    entidadUpdate.setNombre(entidad.getNombre());
                    entidadUpdate.setOsde(entidad.getOsde());
                    entidadUpdate.setMunicipio(entidad.getMunicipio());
                    // entidadUpdate.setListaDeficiencias(entidad.getListaDeficiencias());
                    // entidadUpdate.setListaMultas(entidad.getListaMultas());
                    this.entidadRepository.save(entidadUpdate);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to uptade entities : " + e.getMessage(), e);
        }

    }

    public void delete(Integer id) {
        try {
            if (id != null) {
                Optional<Entidad> eOptional = this.entidadRepository.findById(id);
                if (eOptional.isEmpty()) {
                    throw new EntityNotFoundException("User not found with ID: " + id);
                } else {
                    this.entidadRepository.delete(eOptional.get());
                }
            }
        } catch (Exception e) {
            throw new EntityNotFoundException("User not found");
        }

    }
}
