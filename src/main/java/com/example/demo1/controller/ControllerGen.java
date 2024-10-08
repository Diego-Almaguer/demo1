package com.example.demo1.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.demo1.entity.Ministerio;
import com.example.demo1.entity.Municipio;
import com.example.demo1.entity.Osde;
import com.example.demo1.repository.MinisterioRepository;
import com.example.demo1.repository.MunicipioRepository;
import com.example.demo1.repository.OsdeRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/controllergen")
public class ControllerGen {
    @Autowired
    MinisterioRepository ministerioRepository;
    @Autowired
    OsdeRepository osdeRepository;
    @Autowired
    MunicipioRepository municipioRepository;

    @PostMapping()
    public ResponseEntity<?> create(@Valid @RequestBody Ministerio dto, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return new ResponseEntity<>("Valide los campos", HttpStatus.BAD_REQUEST);
            }
            ministerioRepository.save(dto);
            return new ResponseEntity<>("Create Result", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<?> create(@Valid @RequestBody Osde dto, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return new ResponseEntity<>("Valide los campos", HttpStatus.BAD_REQUEST);
            }
            osdeRepository.save(dto);
            return new ResponseEntity<>("Create Result", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<?> create(@Valid @RequestBody Municipio dto, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return new ResponseEntity<>("Valide los campos", HttpStatus.BAD_REQUEST);
            }
            municipioRepository.save(dto);
            return new ResponseEntity<>("Create Result", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
