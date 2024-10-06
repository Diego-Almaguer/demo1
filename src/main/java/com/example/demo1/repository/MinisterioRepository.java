package com.example.demo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo1.entity.Ministerio;

@Repository
public interface MinisterioRepository extends JpaRepository<Ministerio, Integer> {

}
