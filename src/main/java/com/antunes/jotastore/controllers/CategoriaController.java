package com.antunes.jotastore.controllers;

import com.antunes.jotastore.domain.Categoria;
import com.antunes.jotastore.services.CategoriaService;
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
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @PostMapping("/cadastrar-atualizar")
    public ResponseEntity cadastrarOuAtualizarCategoria(@RequestBody Categoria categoria) {
        service.cadastrar(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body("Categoria cadastrada ou atualizada com sucesso!");
    }

    @GetMapping("/listar")
    public ResponseEntity<Page<Categoria>> buscarTodasCategorias(@PageableDefault(page = 0, size = 10, sort = "id",
            direction = Sort.Direction.ASC) Pageable pegeable) {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodos(pegeable));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity buscarPorId(@PathVariable(value = "id") Integer id) {
        Optional<Categoria> categoria = service.buscarPorId(id);
        return categoria.<ResponseEntity<Object>>map(categoriaModel -> ResponseEntity.status(HttpStatus.OK)
                .body(categoriaModel)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Categoria não encontrada!"));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarCategoria(@PathVariable(value = "id") Integer id) {
        Optional<Categoria> categoria = service.buscarPorId(id);
        if (categoria.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrada!");
        }

        service.deletar(categoria.get());
        return ResponseEntity.status(HttpStatus.OK).body("Categoria deletada com sucesso!");
    }
}
