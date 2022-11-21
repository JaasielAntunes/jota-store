package com.antunes.jotastore.controllers;

import com.antunes.jotastore.domain.Produto;
import com.antunes.jotastore.dtos.ProdutoDTO;
import com.antunes.jotastore.services.ProdutoService;
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
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping("/cadastrar-atualizar")
    public ResponseEntity cadastrarOuAtualizarProduto(@Valid @RequestBody ProdutoDTO prodDto) {
        var prodModel = new Produto();
        BeanUtils.copyProperties(prodDto, prodModel);
        service.cadastrar(prodModel);
        return ResponseEntity.status(HttpStatus.CREATED).body("Produto cadastrado ou atualizado com sucesso!");
    }

    @GetMapping("/listar")
    public ResponseEntity<Page<Produto>> buscarTodasProdutos(@PageableDefault(page = 0, size = 10, sort = "id",
            direction = Sort.Direction.ASC) Pageable pegeable) {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodos(pegeable));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity buscarPorId(@PathVariable(value = "id") Integer id) {
        Optional<Produto> prod = service.buscarPorId(id);
        return prod.<ResponseEntity<Object>>map(produtoModel -> ResponseEntity.status(HttpStatus.OK)
                .body(produtoModel)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Produto não encontrado!"));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarProduto(@PathVariable(value = "id") Integer id) {
        Optional<Produto> prod = service.buscarPorId(id);
        if (prod.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!");
        }

        service.deletar(prod.get());
        return ResponseEntity.status(HttpStatus.OK).body("Produto deletado com sucesso!");
    }
}
