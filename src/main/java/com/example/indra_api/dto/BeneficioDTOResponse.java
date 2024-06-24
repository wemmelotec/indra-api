package com.example.indra_api.dto;

import java.time.LocalDate;

/**
 * @param id
 * @param nome
 * @param descricao
 * @param dataInicio
 * @param dataFim
 */

public record BeneficioDTOResponse(Long id, String nome,String descricao, LocalDate dataInicio, LocalDate dataFim) {
}
