package com.example.indra_api.repository;

import com.example.indra_api.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <h1>Interface que fornece métodos de CRUD para a classe ClienteService.</h1>
 */

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
