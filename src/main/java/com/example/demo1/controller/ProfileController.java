package com.example.demo1.controller;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import com.example.demo1.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import com.example.demo1.entity.Profile;
import com.example.demo1.services.ProfileService;
import com.example.demo1.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/profilecontroller")
public class ProfileController {

    @Autowired
    ProfileService profileService;
    UserService userService;

    @GetMapping()
    public ResponseEntity<?> findAll() {
        try {
            List<Profile> lista = (List<Profile>) profileService.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id) {
        try {
            // TODO Implement Your Logic To Get Data From Service Layer Or Directly From
            // Repository Layer
            return new ResponseEntity<>("GetOne Result", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody Profile profile) {
        try {

            if (profile != null) {

                profileService.save(profile);
                return new ResponseEntity<>(profile, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody Profile profile) {
        try {
            // TODO Implement Your Logic To Update Data And Return Result Through
            // ResponseEntity
            return new ResponseEntity<>("Update Result", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            // TODO Implement Your Logic To Destroy Data And Return Result Through
            // ResponseEntity
            return new ResponseEntity<>("Destroy Result", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
