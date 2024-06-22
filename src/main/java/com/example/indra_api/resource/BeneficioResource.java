package com.example.indra_api.resource;

import com.example.indra_api.model.Beneficio;
import com.example.indra_api.repository.BeneficioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/beneficios")
public class BeneficioResource {

    @Autowired
    private BeneficioRepository beneficioRepository;

    @GetMapping
    public List<Beneficio> listar() {
        return beneficioRepository.findAll();
    }
}
