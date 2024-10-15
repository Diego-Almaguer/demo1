package com.example.demo1.controller;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.demo1.entity.User;

import org.apache.coyote.Request;
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
    public ResponseEntity<Map<String, Object>> find(@PathVariable Integer id) {
        try {
            if (id != null) {
                Optional<Profile> pOptional = profileService.getById(id);
                return new ResponseEntity<>(Map.of("data", pOptional.get()), HttpStatus.OK);

            }
            return new ResponseEntity<>(Map.of("data", "Valide los campos"), HttpStatus.BAD_REQUEST);
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
