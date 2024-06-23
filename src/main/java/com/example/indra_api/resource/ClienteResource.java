package com.example.indra_api.resource;

import com.example.indra_api.model.Cliente;
import com.example.indra_api.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <h1>Expõe os EndPoints da classe Cliente.</h1>
 * <h2>Métodos:</h2>
 * <ol>
 *     <li>listar -> não recebe nenhum parâmatro e retorna uma lista de clientes.</li>
 *     <li>buscarPeloId -> recebe o id do cliente no path e retorna o cliente solicitado.</li>
 *     <li>criar -> recebe um cliente, faz as validação @NotNull no objeto cliente que recebeu e retorna o cliente que foi criado.</li>
 *     <li>remover -> recebe o id do cliente no path, não tem retorno e responde com o @ResponseStatus.</li>
 *     <li>atualizar -> recebe o id do cliente no path, recebe o cliente com os atributos atualizados, faz as validação @NotNull e retorna o cliente atualizado.</li>
 * </ol>
 */
@RestController
@RequestMapping("/api/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @Operation(summary = "Retorna os registros dos clientes cadastrados.")
    @GetMapping
    public List<Cliente> listar() {
        return clienteService.listar();
    }

    @Operation(summary = "Retorna o registro de um único cliente cadastrado.")
    @GetMapping(path = "/{id}")
    public Cliente buscarPeloId(@PathVariable Long id) {
        return clienteService.buscarPeloId(id);
    }

    @Operation(summary = "Salva o registro de um único cliente.")
    @PostMapping
    public ResponseEntity<Cliente> criar(@Valid @RequestBody Cliente cliente, HttpServletResponse response) {
        return clienteService.criar(cliente, response);
    }

    @Operation(summary = "Remove o registro de um único cliente.")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        clienteService.remover(id);
    }

    @Operation(summary = "Atualiza o registro de um único cliente")
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
        return clienteService.atualizar(id, cliente);
    }
}
