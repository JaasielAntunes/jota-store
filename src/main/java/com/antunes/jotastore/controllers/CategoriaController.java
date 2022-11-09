package com.antunes.jotastore.controllers;

import com.antunes.jotastore.domain.Categoria;
import com.antunes.jotastore.services.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    private CategoriaService service;

    @GetMapping("/buscar/{id}")
    public ResponseEntity find(@PathVariable(value = "id") UUID id) {
        Optional<Categoria> categoria = service.buscar(id);
        return categoria.<ResponseEntity<Object>>map(categoriaModel -> ResponseEntity.status(HttpStatus.OK)
                .body(categoriaModel)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Categoria não encontrada!"));
    }
}
