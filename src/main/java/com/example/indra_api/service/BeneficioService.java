package com.example.indra_api.service;

import com.example.indra_api.dto.BeneficioDTOResponse;
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

import java.util.List;

@Service
public class BeneficioService {

    @Autowired
    private BeneficioRepository beneficioRepository;
    @Autowired
    private ClienteService clienteService;

    public BeneficioDTOResponse buscarPeloId(@PathVariable Long id) {
        Beneficio beneficio = beneficioRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Beneficio não encontrado"));
        BeneficioDTOResponse beneficioDTOResponse = new BeneficioDTOResponse(beneficio.getId(), beneficio.getNome(), beneficio.getDescricao(),
                beneficio.getDataInicio(), beneficio.getDataFim());
        return beneficioDTOResponse;
    }

    public ResponseEntity<Cliente> adicionarBeneficio(@PathVariable Long id, @RequestBody Beneficio beneficio, HttpServletResponse response){
        Cliente clienteSalvo = clienteService.buscarPeloId(id);
        beneficio.setIdcliente(clienteSalvo);
        beneficioRepository.save(beneficio);

        clienteSalvo.getBeneficios().add(beneficio);
        clienteService.criar(clienteSalvo,response);

        return ResponseEntity.ok(clienteSalvo);
    }

    public ResponseEntity<List<Beneficio>> listaTodosOsBeneficiosPorCliente(@PathVariable Long id){
        Cliente cliente = clienteService.buscarPeloId(id);
        return ResponseEntity.ok(cliente.getBeneficios());
    }

    public void remover(@PathVariable Long id) {
        beneficioRepository.deleteById(id);
    }

}
