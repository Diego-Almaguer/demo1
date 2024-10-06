package com.example.demo1.controller;

//import lombok.RequiredArgsConstructor;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.demo1.entity.Profile;
import com.example.demo1.entity.ProfileContainer;
import com.example.demo1.entity.User;
import com.example.demo1.services.ProfileService;
import com.example.demo1.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usercontroller")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    ProfileService profileService;

    @GetMapping()
    public ResponseEntity<?> findAll() {
        try {
            List<User> lista = (List<User>) userService.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id) {
        try {
            Optional<User> user = userService.getById(id);
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
     * if (bindingResult.hasErrors()) {
     * return new ResponseEntity<>("valide los campos", HttpStatus.BAD_REQUEST);
     * } else {
     */

    @PostMapping("create")
    public ResponseEntity<?> create(@Valid @RequestBody ProfileContainer profileContainer,
            BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return new ResponseEntity<>("valide los campos", HttpStatus.BAD_REQUEST);
            } else {
                User user = profileContainer.getUser();
                Profile profile = profileContainer.getProfile();
                user.setCreated(new Date());
                userService.save(user);
                profile.setUser(user);
                profileService.save(profile);
                return new ResponseEntity<>(profile, HttpStatus.OK);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("login")
    public ResponseEntity<Map<String, Object>> login(@RequestParam("username") String username,
            @RequestParam("password") String password) {
        try {
            if (username == null || password == null) {
                return new ResponseEntity<>(Map.of("response", "El usuario y la contraseña no pueden ser nulos"),
                        HttpStatus.BAD_REQUEST);
            } else {
                Optional<User> user = userService.findByUsername(username);
                if (user.get().getPassword().equals(password)) {
                    return new ResponseEntity<>(Map.of("response", user), HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(Map.of("response", "Usuario y contraseña incorrectos"),
                            HttpStatus.BAD_REQUEST);
                }

            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody User user, @PathVariable Integer id,
            BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return new ResponseEntity<>("valide los campos", HttpStatus.BAD_REQUEST);
            } else {
                userService.update(user, id);
            }
            return new ResponseEntity<>("Update Result", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            userService.delete(id);
            return new ResponseEntity<>("Destroy Result", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
