package com.example.indra_api.resource;

import com.example.indra_api.model.Cliente;
import com.example.indra_api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteResource {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }
}
