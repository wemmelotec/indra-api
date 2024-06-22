package com.example.indra_api.resource;

import com.example.indra_api.dto.BeneficioDTOResponse;
import com.example.indra_api.model.Beneficio;
import com.example.indra_api.model.Cliente;
import com.example.indra_api.service.BeneficioService;
import com.example.indra_api.service.ClienteService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beneficios")
public class BeneficioResource {

    @Autowired
    private BeneficioService beneficioService;
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}")
    public BeneficioDTOResponse buscarPeloId(@PathVariable Long id){
        return beneficioService.buscarPeloId(id);
    }

    @GetMapping("/{id}/beneficios")
    public ResponseEntity<List<Beneficio>> listaTodosOsBeneficiosPorCliente(@PathVariable Long id){
        //Cliente cliente = clienteService.buscarPeloId(id);
        return beneficioService.listaTodosOsBeneficiosPorCliente(id);//ResponseEntity.ok(cliente.getBeneficios());
    }

    @PostMapping("/{id}/beneficios")
    public ResponseEntity<Cliente> adicionarBeneficio(@PathVariable Long id, @RequestBody Beneficio beneficio, HttpServletResponse response){
        return beneficioService.adicionarBeneficio(id, beneficio, response);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        beneficioService.remover(id);
    }

}
