package com.antunes.jotastore.controllers;

import com.antunes.jotastore.domain.Pedido;
import com.antunes.jotastore.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @PostMapping("/cadastrar-atualizar")
    public ResponseEntity cadastrarOuAtualizarCategoria(@RequestBody Pedido pedido) {
        service.cadastrar(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body("Pedido cadastrado ou atualizado com sucesso!");
    }

    @GetMapping("/listar")
    public ResponseEntity<Page<Pedido>> buscarTodasCategorias(@PageableDefault(page = 0, size = 10, sort = "id",
            direction = Sort.Direction.ASC) Pageable pegeable) {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodos(pegeable));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity buscarPorId(@PathVariable(value = "id") Integer id) {
        Optional<Pedido> pedido = service.buscarPorId(id);
        return pedido.<ResponseEntity<Object>>map(pedidoModel -> ResponseEntity.status(HttpStatus.OK)
                .body(pedidoModel)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Pedido não encontrado!"));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarCategoria(@PathVariable(value = "id") Integer id) {
        Optional<Pedido> pedido = service.buscarPorId(id);
        if (pedido.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não encontrado!");
        }

        service.deletar(pedido.get());
        return ResponseEntity.status(HttpStatus.OK).body("Pedido deletado com sucesso!");
    }
}
