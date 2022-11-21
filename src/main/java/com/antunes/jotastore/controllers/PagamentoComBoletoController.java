package com.antunes.jotastore.controllers;

import com.antunes.jotastore.domain.PagamentoComBoleto;
import com.antunes.jotastore.services.PagamentoComBoletoService;
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
@RequestMapping(value = "/pagamentos-boleto")
public class PagamentoComBoletoController {

    @Autowired
    private PagamentoComBoletoService service;

    @PostMapping("/cadastrar-atualizar")
    public ResponseEntity cadastrarOuAtualizarPagamentoBoleto(@Valid @RequestBody PagamentoComBoleto pagamentoComBoleto) {
        service.cadastrar(pagamentoComBoleto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Pagamento boleto cadastrado ou atualizado com sucesso!");
    }

    @GetMapping("/listar")
    public ResponseEntity<Page<PagamentoComBoleto>> buscarTodasPagamentoBoletos(@PageableDefault(page = 0, size = 10, sort = "id",
            direction = Sort.Direction.ASC) Pageable pegeable) {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodos(pegeable));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity buscarPorId(@PathVariable Integer id) {
        Optional<PagamentoComBoleto> pagBoleto = service.buscarPorId(id);
        return pagBoleto.<ResponseEntity<Object>>map(pagamentoComBoletoModel -> ResponseEntity.status(HttpStatus.OK)
                .body(pagamentoComBoletoModel)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Pagamento boleto não encontrado!"));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarPagamentoBoleto(@PathVariable Integer id) {
        Optional<PagamentoComBoleto> pagBoleto = service.buscarPorId(id);
        if (pagBoleto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pagamento boleto não encontrado!");
        }

        service.deletar(pagBoleto.get());
        return ResponseEntity.status(HttpStatus.OK).body("Pagamento boleto deletado com sucesso!");
    }
}
