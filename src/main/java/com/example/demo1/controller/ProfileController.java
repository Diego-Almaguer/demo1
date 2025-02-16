package com.example.demo1.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo1.entity.Profile;
import com.example.demo1.services.ProfileService;
import com.example.demo1.services.UserService;

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
            if (id != null) {
                Optional<Profile> pOptional = profileService.getByUser(id);
                return new ResponseEntity<>(pOptional.get(), HttpStatus.OK);

            }
            return new ResponseEntity<>("Valide los campos", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Profile profile, @PathVariable Integer id) {
        try {
            if (profile != null) {
                profileService.update(profile, id);
                return new ResponseEntity<>("Update Result", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No hay datos para editar", HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            if (id != null) {
                profileService.delete(id);
                return new ResponseEntity<>("Destroy Result", HttpStatus.OK);
            }
            return new ResponseEntity<>("Not found Id", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
