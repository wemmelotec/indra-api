package com.example.indra_api.service;

import com.example.indra_api.model.Beneficio;
import com.example.indra_api.model.Cliente;
import com.example.indra_api.repository.BeneficioRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BeneficioService {

    @Autowired
    private BeneficioRepository beneficioRepository;
    @Autowired
    private ClienteService clienteService;

    public Beneficio buscarPeloId(@PathVariable Long id) {
        return beneficioRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Beneficio não encontrado"));
    }

    public ResponseEntity<Cliente> adicionarBeneficio(@PathVariable Long id, @RequestBody Beneficio beneficio, HttpServletResponse response){
        Cliente clienteSalvo = clienteService.buscarPeloId(id);
        beneficio.setIdcliente(clienteSalvo);
        beneficioRepository.save(beneficio);

        clienteSalvo.getBeneficios().add(beneficio);
        clienteService.criar(clienteSalvo,response);

        return ResponseEntity.ok(clienteSalvo);
    }

}
