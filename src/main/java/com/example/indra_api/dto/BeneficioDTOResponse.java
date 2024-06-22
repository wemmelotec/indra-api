package com.example.indra_api.dto;

import java.time.LocalDate;

public record BeneficioDTOResponse(Long id, String nome,String descricao, LocalDate dataInicio, LocalDate dataFim) {
}
