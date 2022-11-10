package com.antunes.jotastore.controllers;

import com.antunes.jotastore.domain.Cidade;
import com.antunes.jotastore.domain.Estado;
import com.antunes.jotastore.services.CidadeService;
import com.antunes.jotastore.services.EstadoService;
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
@RequestMapping(value = "/estados")
public class EstadoController {

    @Autowired
    private EstadoService service;

    @PostMapping("/cadastrar-atualizar")
    public ResponseEntity cadastrarOuAtualizarCategoria(@RequestBody Estado estado) {
        service.cadastrar(estado);
        return ResponseEntity.status(HttpStatus.CREATED).body("Estado cadastrado ou atualizado com sucesso!");
    }

    @GetMapping("/listar")
    public ResponseEntity<Page<Estado>> buscarTodasCategorias(@PageableDefault(page = 0, size = 10, sort = "id",
            direction = Sort.Direction.ASC) Pageable pegeable) {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodos(pegeable));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity find(@PathVariable(value = "id") Integer id) {
        Optional<Estado> estado = service.buscarPorId(id);
        return estado.<ResponseEntity<Object>>map(estadoModel -> ResponseEntity.status(HttpStatus.OK)
                .body(estadoModel)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Estado não encontrado!"));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarCategoria(@PathVariable(value = "id") Integer id) {
        Optional<Estado> estado = service.buscarPorId(id);
        if (estado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estado não encontrado!");
        }

        service.deletar(estado.get());
        return ResponseEntity.status(HttpStatus.OK).body("Estado deletado com sucesso!");
    }
}