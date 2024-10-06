package com.example.demo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo1.entity.Entidad;

@Repository
public interface EntidadRepository extends JpaRepository<Entidad, Integer> {

}
