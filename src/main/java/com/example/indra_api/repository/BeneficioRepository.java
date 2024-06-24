package com.example.indra_api.repository;

import com.example.indra_api.model.Beneficio;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <h1>Interface que fornece métodos de CRUD para a classe BeneficioService.</h1>
 */
public interface BeneficioRepository extends JpaRepository<Beneficio, Long> {
}
