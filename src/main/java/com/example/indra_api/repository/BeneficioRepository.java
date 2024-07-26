package com.example.indra_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.indra_api.dto.BeneficioDTOTest;
import com.example.indra_api.model.Beneficio;

/**
 * <h1>Interface que fornece métodos de CRUD para a classe
 * BeneficioService.</h1>
 */
public interface BeneficioRepository extends JpaRepository<Beneficio, Long> {
	
	@Query("select new com.example.indra_api.dto.BeneficioDTOTest(id, nome, descricao)"
			+ "from Beneficio")
	List<BeneficioDTOTest> listarBeneficioDTOTests();
	
}
