package com.example.indra_api.resource;

import com.example.indra_api.dto.BeneficioDTOResponse;
import com.example.indra_api.model.Beneficio;
import com.example.indra_api.model.Cliente;
import com.example.indra_api.service.BeneficioService;
import com.example.indra_api.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <h1>Expõe os EndPoints da classe Benefício.</h1>
 * <h2>Métodos:</h2>
 * <ol>
 *     <li>buscarPeloId -> recebe o id do benefício no path e retorna o benefício.</li>
 *     <li>listaTodosOsBeneficiosPorCliente -> recebe o id do cliente no path e retorna todos os beneficios associados ao cliente.</li>
 *     <li>adicionarBeneficio -> recebe o id do cliente e um benefício e retorna o cliente.</li>
 *     <li>remover -> recebe o id do benefício no path, não tem retorno e responde com o @ResponseStatus.</li>
 * </ol>
 */
@RestController
@RequestMapping("/api/beneficios")
public class BeneficioResource {

    @Autowired
    private BeneficioService beneficioService;
    @Autowired
    private ClienteService clienteService;

    @Operation(summary = "Retorna o registro de um único benefício cadastrado.")
    @GetMapping("/{id}")
    public BeneficioDTOResponse buscarPeloId(@PathVariable Long id) {
        return beneficioService.buscarPeloId(id);
    }

    @Operation(summary = "Retorna os registros dos benefícios por cliente.")
    @GetMapping("/{id}/beneficios")
    public ResponseEntity<List<BeneficioDTOResponse>> listaTodosOsBeneficiosPorCliente(@PathVariable Long id) {
        return beneficioService.listaTodosOsBeneficiosPorCliente(id);//ResponseEntity.ok(cliente.getBeneficios());
    }

    @Operation(summary = "Adiciona o registro de um único benefício a um cliente já cadastrado.")
    @PostMapping("/{id}/beneficios")
    public ResponseEntity<Cliente> adicionarBeneficio(@PathVariable Long id, @RequestBody Beneficio beneficio, HttpServletResponse response) {
        return beneficioService.adicionarBeneficio(id, beneficio, response);
    }

    @Operation(summary = "Remove o registro de um único benefício.")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        beneficioService.remover(id);
    }

}
