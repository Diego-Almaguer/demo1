package com.example.demo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo1.entity.Multa;

@Repository
public interface MultaRepository extends JpaRepository<Multa, Integer> {

}
