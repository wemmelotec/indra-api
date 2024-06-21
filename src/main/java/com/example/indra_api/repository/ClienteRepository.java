package com.example.indra_api.repository;

import com.example.indra_api.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
