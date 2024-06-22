package com.example.indra_api.resource;

import com.example.indra_api.model.Cliente;
import com.example.indra_api.service.ClienteService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteResource {


    @Autowired
    private ClienteService clienteService;


    @GetMapping
    public List<Cliente> listar() {
        return clienteService.listar();
    }

    @GetMapping(path = "/{id}")
    public Cliente buscarPeloId(@PathVariable Long id) {
        return clienteService.buscarPeloId(id);
    }

    @PostMapping
    public ResponseEntity<Cliente> criar(@Valid @RequestBody Cliente cliente, HttpServletResponse response) {
        return clienteService.criar(cliente, response);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        clienteService.remover(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
        return clienteService.atualizar(id, cliente);
    }
}
