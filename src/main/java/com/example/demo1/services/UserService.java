package com.example.demo1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.entity.User;
import com.example.demo1.repository.UserRepository;
import java.util.*;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void save(User user) {
        try {
            if (user != null) {
                this.userRepository.save(user);
            } else {
                throw new IllegalArgumentException("User object is null");
            }

        } catch (Exception e) {

            throw new RuntimeException("Failed to save user: " + e.getMessage(), e);
        }

    }

    public Optional<User> getById(Integer id) {
        try {
            if (id != null) {
                return this.userRepository.findById(id);
            } else {
                throw new IllegalArgumentException("User id is null");
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to find user : " + e.getMessage(), e);
        }

    }

    public Iterable<User> findAll() {
        try {
            return this.userRepository.findAll();

        } catch (Exception e) {
            throw new RuntimeException("Failed to findAll users : " + e.getMessage(), e);
        }

    }

    public void update(User user, Integer id) {
        try {
            if (id != null) {
                Optional<User> userFind = this.userRepository.findById(id);
                if (userFind.isEmpty()) {
                    throw new EntityNotFoundException("User not found with ID: " + id);
                } else {
                    User userUpdate = userFind.get();
                    userUpdate.setUsername(user.getUsername());
                    userUpdate.setPassword(user.getPassword());
                    userUpdate.setApellido(user.getApellido());
                    userUpdate.setEmail(user.getEmail());
                    userUpdate.setAdmin(user.getAdmin());
                    userUpdate.setNombre(user.getNombre());
                    userUpdate.setCreated(user.getCreated());
                    this.userRepository.save(userUpdate);
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public void delete(Integer id) {
        try {
            if (id != null) {
                Optional<User> user = this.userRepository.findById(id);
                if (user.isEmpty()) {
                    throw new EntityNotFoundException("User not found with ID: " + id);
                } else {
                    this.userRepository.delete(user.get());
                }
            }
        } catch (Exception e) {
            throw new EntityNotFoundException("User not found");
        }

    }

    public Optional<User> findByUsername(String username) {
        try {
            if (username == null) {
                throw new IllegalArgumentException("User object is null");

            } else {
                List<User> lista = this.userRepository.findAll();
                for (User user : lista) {
                    if (user.getUsername().equals(username)) {
                        return Optional.of(user);
                    }
                }
            }
        } catch (Exception e) {
            throw new EntityNotFoundException("User not found");
        }
        return Optional.empty();
    }

}
