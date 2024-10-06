package com.example.demo1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.example.demo1.entity.Entidad;
import com.example.demo1.entity.Multa;
//import com.example.demo1.repository.EntidadRepository;
import com.example.demo1.repository.MultaRepository;

import java.util.*;
import jakarta.persistence.EntityNotFoundException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MultaService {
    @Autowired
    MultaRepository multaRepository;

    public void save(Multa multa) {
        try {
            if (multa != null) {
                this.multaRepository.save(multa);
            } else {
                throw new IllegalArgumentException("User object is null");
            }

        } catch (Exception e) {

            throw new RuntimeException("Failed to save user: " + e.getMessage(), e);
        }

    }

    public Optional<Multa> getById(Integer id) {
        try {
            if (id != null) {
                return this.multaRepository.findById(id);
            } else {
                throw new IllegalArgumentException("User id is null");
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to find user : " + e.getMessage(), e);
        }

    }

    public Iterable<Multa> findAll() {
        try {
            return this.multaRepository.findAll();

        } catch (Exception e) {
            throw new RuntimeException("Failed to findAll users : " + e.getMessage(), e);
        }

    }

    public void update(Multa multa, Integer id) {
        try {
            if (id != null) {
                Optional<Multa> multaFind = this.multaRepository.findById(id);
                if (multaFind.isEmpty()) {
                    throw new EntityNotFoundException("User not found with ID: " + id);
                } else {
                    Multa multaUpdate = multaFind.get();
                    multaUpdate.setPrecio(multa.getPrecio());
                    multaUpdate.setDescripcion(multa.getDescripcion());
                    multaUpdate.setEntidad(multa.getEntidad());
                    multaUpdate.setFecha(multa.getFecha());
                    multaUpdate.setInspector(multa.getInspector());
                    this.multaRepository.save(multaUpdate);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to uptade multas : " + e.getMessage(), e);
        }

    }

    public void delete(Integer id) {
        try {
            if (id != null) {
                Optional<Multa> mOptional = this.multaRepository.findById(id);
                if (mOptional.isEmpty()) {
                    throw new EntityNotFoundException("multa not found with ID: " + id);
                } else {
                    this.multaRepository.delete(mOptional.get());
                }
            }
        } catch (Exception e) {
            throw new EntityNotFoundException("multa not found");
        }

    }
}
