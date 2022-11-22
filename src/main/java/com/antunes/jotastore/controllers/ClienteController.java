package com.antunes.jotastore.controllers;

import com.antunes.jotastore.domain.Cliente;
import com.antunes.jotastore.services.ClienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping("/cadastrar-atualizar")
    public ResponseEntity cadastrarOuAtualizarCliente(@Valid @RequestBody Cliente clienteDto) {
        var clienteModel = new Cliente();
        BeanUtils.copyProperties(clienteDto, clienteModel);
        service.cadastrar(clienteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cliente cadastrado ou atualizado com sucesso!");
    }

    @GetMapping("/listar")
    public ResponseEntity<Page<Cliente>> buscarTodasClientes(@PageableDefault(page = 0, size = 10, sort = "id",
            direction = Sort.Direction.ASC) Pageable pegeable) {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodos(pegeable));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity buscarPorId(@PathVariable Integer id) {
        Optional<Cliente> cliente = service.buscarPorId(id);
        return cliente.<ResponseEntity<Object>>map(clienteModel -> ResponseEntity.status(HttpStatus.OK)
                .body(clienteModel)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Cliente não encontrado!"));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarCliente(@PathVariable Integer id) {
        Optional<Cliente> cliente = service.buscarPorId(id);
        if (cliente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
        }

        service.deletar(cliente.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso!");
    }
}
