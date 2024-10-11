package com.example.demo1.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.entity.Inspector;

import com.example.demo1.repository.InspectorRepository;

import jakarta.persistence.EntityNotFoundException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class InspectorService {
    @Autowired
    InspectorRepository inspectorRepository;

    public void save(Inspector inspector) {
        try {
            if (inspector != null) {
                this.inspectorRepository.save(inspector);
            } else {
                throw new IllegalArgumentException("User object is null");
            }

        } catch (Exception e) {

            throw new RuntimeException("Failed to save user: " + e.getMessage(), e);
        }

    }

    public Optional<Inspector> getById(Integer id) {
        try {
            if (id != null) {
                return this.inspectorRepository.findById(id);
            } else {
                throw new IllegalArgumentException("User id is null");
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to find user : " + e.getMessage(), e);
        }

    }

    public Optional<Inspector> findByCi(String ci) {
        try {
            if (ci == null || ci.length() <= 0) {
                throw new IllegalArgumentException("User object is null");

            } else {
                List<Inspector> lista = this.inspectorRepository.findAll();
                for (Inspector inspector : lista) {
                    if (inspector.getCi().equals(ci)) {
                        return Optional.of(inspector);
                    }
                }
            }
        } catch (Exception e) {
            throw new EntityNotFoundException("User not found");
        }
        return Optional.empty();
    }

    public Iterable<Inspector> findAll() {
        try {
            return this.inspectorRepository.findAll();

        } catch (Exception e) {
            throw new RuntimeException("Failed to findAll users : " + e.getMessage(), e);
        }

    }

    public void update(Inspector inspector, Integer id) {
        try {
            if (id != null) {
                Optional<Inspector> inspectorFind = this.inspectorRepository.findById(id);
                if (inspectorFind.isEmpty()) {
                    throw new EntityNotFoundException("User not found with ID: " + id);
                } else {
                    Inspector inspectorUpdate = inspectorFind.get();
                    inspectorUpdate.setApellido(inspector.getApellido());
                    inspectorUpdate.setCi(inspector.getCi());
                    inspectorUpdate.setEdad(inspector.getEdad());
                    inspectorUpdate.setMunicipio(inspector.getMunicipio());
                    inspectorUpdate.setNombre(inspector.getNombre());
                    inspectorUpdate.setRango(inspector.getRango());
                    this.inspectorRepository.save(inspectorUpdate);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to update inspectors : " + e.getMessage(), e);
        }

    }

    public void delete(Integer id) {
        try {
            if (id != null) {
                Optional<Inspector> iOptional = this.inspectorRepository.findById(id);
                if (iOptional.isEmpty()) {
                    throw new EntityNotFoundException("User not found with ID: " + id);
                } else {
                    this.inspectorRepository.delete(iOptional.get());
                }
            }
        } catch (Exception e) {
            throw new EntityNotFoundException("User not found");
        }

    }

}
