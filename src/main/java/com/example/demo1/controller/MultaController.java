package com.example.demo1.controller;

import lombok.RequiredArgsConstructor;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.demo1.entity.Deficiencia;
import com.example.demo1.entity.Multa;
import com.example.demo1.services.DeficienciaService;
import com.example.demo1.services.MultaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/multacontroller")
public class MultaController {

    @Autowired
    MultaService multaService;

    @GetMapping()
    public ResponseEntity<?> findAll() {
        try {
            List<Multa> lista = (List<Multa>) multaService.findAll();

            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id) {
        try {
            Optional<Multa> oDeficiencia = multaService.getById(id);
            return new ResponseEntity<>(oDeficiencia.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<?> create(@Valid @RequestBody Multa dto, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return new ResponseEntity<>("valide los campos", HttpStatus.BAD_REQUEST);
            }
            multaService.save(dto);
            return new ResponseEntity<>("Create Result", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping()
    public ResponseEntity<?> update(@Valid @RequestBody Multa dto, @PathVariable Integer id,
            BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return new ResponseEntity<>("Valide los campos", HttpStatus.BAD_REQUEST);
            }
            multaService.update(dto, id);
            return new ResponseEntity<>("Update Result", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            multaService.delete(id);
            return new ResponseEntity<>("Destroy Result", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
