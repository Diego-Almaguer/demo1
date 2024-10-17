package com.example.demo1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import com.example.demo1.repository.MinisterioRepository;
import com.example.demo1.repository.MunicipioRepository;
import com.example.demo1.repository.OsdeRepository;
import com.example.demo1.entity.*;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ServiceDefault {
    @Autowired
    MinisterioRepository ministerioRepository;
    @Autowired
    OsdeRepository osdeRepository;
    @Autowired
    MunicipioRepository municipioRepository;

    public void crear() {
        List<Ministerio> lista = Arrays.asList(
                new Ministerio(1, "Ministerio de Finanzas", null),
                new Ministerio(2, "Ministerio de Comercio", null)

        );
        ministerioRepository.saveAll(lista);

        List<Municipio> listaMunicipios = Arrays.asList(
                new Municipio(1, "Las Tunas"),
                new Municipio(2, "Jobabo"),
                new Municipio(3, "Calixto"));

        municipioRepository.saveAll(listaMunicipios);
    }
}
