package com.antunes.jotastore.controllers;

import com.antunes.jotastore.domain.PagamentoComCartao;
import com.antunes.jotastore.services.PagamentoComCartaoService;
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
@RequestMapping(value = "/pagamentos-cartao")
public class PagamentoComCartaoController {

    @Autowired
    private PagamentoComCartaoService service;

    @PostMapping("/cadastrar-atualizar")
    public ResponseEntity cadastrarOuAtualizarPagamentoCartao(@Valid @RequestBody PagamentoComCartao pagamentoComCartao) {
        service.cadastrar(pagamentoComCartao);
        return ResponseEntity.status(HttpStatus.CREATED).body("Pagamento cartão cadastrado ou atualizado com sucesso!");
    }

    @GetMapping("/listar")
    public ResponseEntity<Page<PagamentoComCartao>> buscarTodasPagamentoCartaos(@PageableDefault(page = 0, size = 10, sort = "id",
            direction = Sort.Direction.ASC) Pageable pegeable) {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodos(pegeable));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity buscarPorId(@PathVariable(value = "id") Integer id) {
        Optional<PagamentoComCartao> pagCartao = service.buscarPorId(id);
        return pagCartao.<ResponseEntity<Object>>map(pagamentoComCartaoModel -> ResponseEntity.status(HttpStatus.OK)
                .body(pagamentoComCartaoModel)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Pagamento cartão não encontrado!"));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarPagamentoCartao(@PathVariable(value = "id") Integer id) {
        Optional<PagamentoComCartao> pagCartao = service.buscarPorId(id);
        if (pagCartao.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pagamento cartão não encontrado!");
        }

        service.deletar(pagCartao.get());
        return ResponseEntity.status(HttpStatus.OK).body("Pagamento cartão deletado com sucesso!");
    }
}
