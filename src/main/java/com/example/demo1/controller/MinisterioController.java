package com.example.demo1.controller;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo1.entity.*;

import com.example.demo1.repository.MinisterioRepository;
import com.example.demo1.repository.MunicipioRepository;
import com.example.demo1.repository.OsdeRepository;

@RestController
@RequestMapping("/ministeriocontroller")
public class MinisterioController {
    @Autowired
    MinisterioRepository ministerioRepository;
    @Autowired
    OsdeRepository osdeRepository;
    @Autowired
    MunicipioRepository municipioRepository;

    @GetMapping("/ministerio")
    public ResponseEntity<Map<String, Object>> findAll() {
        try {
            List<Ministerio> lista = ministerioRepository.findAll();
            return new ResponseEntity<>(Map.of("data", lista), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/osde")
    public ResponseEntity<?> findAllOsdes() {
        try {
            List<Osde> lista = osdeRepository.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/municipio")
    public ResponseEntity<?> findAllMunicipio() {
        try {
            List<Municipio> lista = municipioRepository.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
