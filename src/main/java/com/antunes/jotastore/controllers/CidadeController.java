package com.antunes.jotastore.controllers;

import com.antunes.jotastore.domain.Cidade;
import com.antunes.jotastore.dtos.CidadeDTO;
import com.antunes.jotastore.services.CidadeService;
import org.springframework.beans.BeanUtils;
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
@RequestMapping(value = "/cidades")
public class CidadeController {

    @Autowired
    private CidadeService service;

    @PostMapping("/cadastrar-atualizar")
    public ResponseEntity cadastrarOuAtualizarCidade(@RequestBody CidadeDTO cidadeDto) {
        var cidadeModel = new Cidade();
        BeanUtils.copyProperties(cidadeDto, cidadeModel);
        service.cadastrar(cidadeModel);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cidade cadastrada ou atualizada com sucesso!");
    }

    @GetMapping("/listar")
    public ResponseEntity<Page<Cidade>> buscarTodasCidades(@PageableDefault(page = 0, size = 10, sort = "id",
            direction = Sort.Direction.ASC) Pageable pegeable) {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodos(pegeable));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity buscarPorId(@PathVariable(value = "id") Integer id) {
        Optional<Cidade> cidade = service.buscarPorId(id);
        return cidade.<ResponseEntity<Object>>map(cidadeModel -> ResponseEntity.status(HttpStatus.OK)
                .body(cidadeModel)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Cidade não encontrada!"));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarCidade(@PathVariable(value = "id") Integer id) {
        Optional<Cidade> cidade = service.buscarPorId(id);
        if (cidade.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cidade não encontrada!");
        }

        service.deletar(cidade.get());
        return ResponseEntity.status(HttpStatus.OK).body("Cidade deletada com sucesso!");
    }
}
