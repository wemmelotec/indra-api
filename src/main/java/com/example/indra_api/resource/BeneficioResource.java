package com.example.indra_api.resource;

import com.example.indra_api.model.Beneficio;
import com.example.indra_api.model.Cliente;
import com.example.indra_api.service.BeneficioService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/beneficios")
public class BeneficioResource {

    @Autowired
    private BeneficioService beneficioService;

    @GetMapping("/{id}")
    public Beneficio buscarPeloId(@PathVariable Long id){
        return beneficioService.buscarPeloId(id);
    }

    @PostMapping("/{id}/beneficios")
    public ResponseEntity<Cliente> adicionarBeneficio(@PathVariable Long id, @RequestBody Beneficio beneficio, HttpServletResponse response){
        return beneficioService.adicionarBeneficio(id, beneficio, response);
    }

}
