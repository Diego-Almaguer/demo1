package com.example.demo1.controller;

import lombok.RequiredArgsConstructor;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.demo1.entity.Deficiencia;
import com.example.demo1.repository.DeficienciaRepository;
import com.example.demo1.services.DeficienciaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/deficienciacontroller")
public class DeficienciaController {
    @Autowired
    DeficienciaService deficienciaService;

    @GetMapping()
    public ResponseEntity<?> findAll() {
        try {
            List<Deficiencia> lista = (List<Deficiencia>) deficienciaService.findAll();

            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id) {
        try {
            Optional<Deficiencia> oDeficiencia = deficienciaService.getById(id);
            return new ResponseEntity<>(oDeficiencia.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<?> create(@Valid @RequestBody Deficiencia dto, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return new ResponseEntity<>("valide los campos", HttpStatus.BAD_REQUEST);
            }
            deficienciaService.save(dto);
            return new ResponseEntity<>("Create Result", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping()
    public ResponseEntity<?> update(@Valid @RequestBody Deficiencia dto, @PathVariable Integer id,
            BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return new ResponseEntity<>("Valide los campos", HttpStatus.BAD_REQUEST);
            }
            deficienciaService.update(dto, id);
            return new ResponseEntity<>("Update Result", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            deficienciaService.delete(id);
            return new ResponseEntity<>("Destroy Result", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
