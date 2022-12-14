package com.antunes.jotastore.controllers;

import com.antunes.jotastore.domain.Endereco;
import com.antunes.jotastore.dtos.EnderecoDTO;
import com.antunes.jotastore.services.EnderecoService;
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
@RequestMapping(value = "/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @PostMapping("/cadastrar-atualizar")
    public ResponseEntity cadastrarOuAtualizarEndereco(@Valid @RequestBody EnderecoDTO enderecoDto) {
        var enderecoModel = new Endereco();
        BeanUtils.copyProperties(enderecoDto, enderecoModel);
        service.cadastrar(enderecoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body("Endereço cadastrado ou atualizado com sucesso!");
    }

    @GetMapping("/listar")
    public ResponseEntity<Page<Endereco>> buscarTodasEnderecos(@PageableDefault(page = 0, size = 10, sort = "id",
            direction = Sort.Direction.ASC) Pageable pegeable) {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodos(pegeable));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity buscarPorId(@PathVariable Integer id) {
        Optional<Endereco> endereco = service.buscarPorId(id);
        return endereco.<ResponseEntity<Object>>map(enderecoModel -> ResponseEntity.status(HttpStatus.OK)
                .body(enderecoModel)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Endereço não encontrado!"));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarEndereco(@PathVariable Integer id) {
        Optional<Endereco> endereco = service.buscarPorId(id);
        if (endereco.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço não encontrado!");
        }

        service.deletar(endereco.get());
        return ResponseEntity.status(HttpStatus.OK).body("Endereço deletado com sucesso!");
    }
}
