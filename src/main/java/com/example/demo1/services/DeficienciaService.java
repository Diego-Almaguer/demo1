package com.example.demo1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.entity.Deficiencia;

import com.example.demo1.repository.DeficienciaRepository;

import java.util.*;
import jakarta.persistence.EntityNotFoundException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DeficienciaService {
    @Autowired
    DeficienciaRepository deficienciaRepository;

    public void save(Deficiencia deficiencia) {
        try {
            if (deficiencia != null) {
                this.deficienciaRepository.save(deficiencia);
            } else {
                throw new IllegalArgumentException("User object is null");
            }

        } catch (Exception e) {

            throw new RuntimeException("Failed to save user: " + e.getMessage(), e);
        }

    }

    public Optional<Deficiencia> getById(Integer id) {
        try {
            if (id != null) {
                return this.deficienciaRepository.findById(id);
            } else {
                throw new IllegalArgumentException("User id is null");
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to find user : " + e.getMessage(), e);
        }

    }

    public Iterable<Deficiencia> findAll() {
        try {
            return this.deficienciaRepository.findAll();

        } catch (Exception e) {
            throw new RuntimeException("Failed to findAll users : " + e.getMessage(), e);
        }

    }

    public void update(Deficiencia deficiencia, Integer id) {
        try {
            if (id != null) {
                Optional<Deficiencia> deficFind = this.deficienciaRepository.findById(id);
                if (deficFind.isEmpty()) {
                    throw new EntityNotFoundException("User not found with ID: " + id);
                } else {
                    Deficiencia deficUpdate = deficFind.get();
                    deficUpdate.setNombre(deficiencia.getNombre());
                    deficUpdate.setDescripcion(deficiencia.getDescripcion());
                    deficUpdate.setFecha(deficiencia.getFecha());
                    this.deficienciaRepository.save(deficUpdate);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to uptade multas : " + e.getMessage(), e);
        }

    }

    public void delete(Integer id) {
        try {
            if (id != null) {
                Optional<Deficiencia> dOptional = this.deficienciaRepository.findById(id);
                if (dOptional.isEmpty()) {
                    throw new EntityNotFoundException("multa not found with ID: " + id);
                } else {
                    this.deficienciaRepository.delete(dOptional.get());
                }
            }
        } catch (Exception e) {
            throw new EntityNotFoundException("multa not found");
        }

    }
}
