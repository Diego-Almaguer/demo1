package com.example.demo1.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.entity.Profile;
import com.example.demo1.repository.ProfileRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProfileService {
    @Autowired
    ProfileRepository profileRepository;

    public void save(Profile profile) {
        try {
            if (profile != null) {
                this.profileRepository.save(profile);
            } else {
                throw new IllegalArgumentException("User object is null");
            }

        } catch (Exception e) {

            throw new RuntimeException("Failed to save user: " + e.getMessage(), e);
        }

    }

    public Optional<Profile> getById(Integer id) {
        try {
            if (id != null) {
                return this.profileRepository.findById(id);
            } else {
                throw new IllegalArgumentException("User id is null");
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to find user : " + e.getMessage(), e);
        }

    }

    public Iterable<Profile> findAll() {
        try {
            return this.profileRepository.findAll();

        } catch (Exception e) {
            throw new RuntimeException("Failed to findAll users : " + e.getMessage(), e);
        }

    }

    public void update(Profile profile, Integer id) {
        try {
            if (id != null) {
                Optional<Profile> userFind = this.profileRepository.findById(id);
                if (userFind.isEmpty()) {
                    throw new EntityNotFoundException("User not found with ID: " + id);
                } else {
                    Profile userUpdate = userFind.get();
                    userUpdate.setFoto(profile.getFoto());
                    userUpdate.setUsername(profile.getUsername());
                    userUpdate.setPassword(profile.getPassword());
                    this.profileRepository.save(userUpdate);
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public void delete(Integer id) {
        try {
            if (id != null) {
                Optional<Profile> user = this.profileRepository.findById(id);
                if (user.isEmpty()) {
                    throw new EntityNotFoundException("User not found with ID: " + id);
                } else {
                    this.profileRepository.delete(user.get());
                }
            }
        } catch (Exception e) {
            throw new EntityNotFoundException("User not found");
        }

    }

    public Optional<Profile> findByUsername(String username) {
        try {
            if (username == null) {
                throw new IllegalArgumentException("User object is null");

            } else {
                List<Profile> lista = (List<Profile>) this.findAll();
                for (Profile profile : lista) {
                    if (profile.getUsername().equals(username)) {
                        return Optional.of(profile);
                    }
                }
            }
        } catch (Exception e) {
            throw new EntityNotFoundException("User not found");
        }
        return Optional.empty();
    }
}
