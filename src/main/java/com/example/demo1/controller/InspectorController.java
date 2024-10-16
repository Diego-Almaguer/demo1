package com.example.demo1.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.demo1.entity.Inspector;
import com.example.demo1.services.InspectorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/inspectorcontroller")
public class InspectorController {
    @Autowired
    InspectorService inspectorService;

    @GetMapping()
    public ResponseEntity<?> findAll() {
        try {
            List<Inspector> lista = (List<Inspector>) inspectorService.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id) {
        try {
            if (id != null && id > 0) {
                Optional<Inspector> insOptional = inspectorService.getById(id);
                return new ResponseEntity<>(insOptional.get(), HttpStatus.OK);
            }
            return new ResponseEntity<>("El id no puede ser nulo ni menor que cero", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<?> create(@Valid @RequestBody Inspector inspector, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return new ResponseEntity<>("Valide los campos", HttpStatus.BAD_REQUEST);
            }
            inspectorService.save(inspector);
            return new ResponseEntity<>("Create Result", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Inspector inspector, @PathVariable Integer id,
            BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return new ResponseEntity<>("Valide los campos", HttpStatus.BAD_REQUEST);
            }
            inspectorService.update(inspector, id);
            return new ResponseEntity<>("Update Result", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            inspectorService.delete(id);
            return new ResponseEntity<>("Destroy Result", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
