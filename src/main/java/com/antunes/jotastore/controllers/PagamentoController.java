package com.antunes.jotastore.controllers;

import com.antunes.jotastore.domain.Pagamento;
import com.antunes.jotastore.dtos.PagamentoDTO;
import com.antunes.jotastore.services.PagamentoService;
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
@RequestMapping(value = "/pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoService service;

    @PostMapping("/cadastrar-atualizar")
    public ResponseEntity cadastrarOuAtualizarPagamento(@Valid @RequestBody PagamentoDTO pagamentoDto) {
        var pagamentoModel = new Pagamento();
        BeanUtils.copyProperties(pagamentoDto, pagamentoModel);
        service.cadastrar(pagamentoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body("Pagamento cadastrado ou atualizado com sucesso!");
    }

    @GetMapping("/listar")
    public ResponseEntity<Page<Pagamento>> buscarTodasPagamentos(@PageableDefault(page = 0, size = 10, sort = "id",
            direction = Sort.Direction.ASC) Pageable pegeable) {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodos(pegeable));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity buscarPorId(@PathVariable(value = "id") Integer id) {
        Optional<Pagamento> pag = service.buscarPorId(id);
        return pag.<ResponseEntity<Object>>map(pagamentoModel -> ResponseEntity.status(HttpStatus.OK)
                .body(pagamentoModel)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Pagamento não encontrado!"));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarPagamento(@PathVariable(value = "id") Integer id) {
        Optional<Pagamento> pag = service.buscarPorId(id);
        if (pag.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pagamento não encontrado!");
        }

        service.deletar(pag.get());
        return ResponseEntity.status(HttpStatus.OK).body("Pagamento deletado com sucesso!");
    }
}
