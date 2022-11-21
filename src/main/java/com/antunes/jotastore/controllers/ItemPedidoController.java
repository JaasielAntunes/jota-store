package com.antunes.jotastore.controllers;

import com.antunes.jotastore.domain.ItemPedido;
import com.antunes.jotastore.dtos.ItemPedidoDTO;
import com.antunes.jotastore.services.ItemPedidoService;
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
@RequestMapping(value = "/item-pedidos")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService service;

    @PostMapping("/cadastrar-atualizar")
    public ResponseEntity cadastrarOuAtualizarItemPedido(@Valid @RequestBody ItemPedidoDTO itemPedidoDto) {
        var itemPedidoModel = new ItemPedido();
        BeanUtils.copyProperties(itemPedidoDto, itemPedidoModel);
        service.cadastrar(itemPedidoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body("Item pedido cadastrado ou atualizado com sucesso!");
    }

    @GetMapping("/listar")
    public ResponseEntity<Page<ItemPedido>> buscarTodasItemPedidos(@PageableDefault(page = 0, size = 10, sort = "id",
            direction = Sort.Direction.ASC) Pageable pegeable) {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodos(pegeable));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity buscarPorId(@PathVariable(value = "id") Integer id) {
        Optional<ItemPedido> itemPedido = service.buscarPorId(id);
        return itemPedido.<ResponseEntity<Object>>map(itemPedidoModel -> ResponseEntity.status(HttpStatus.OK)
                .body(itemPedidoModel)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Item pedido não encontrado!"));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarItemPedido(@PathVariable(value = "id") Integer id) {
        Optional<ItemPedido> itemPedido = service.buscarPorId(id);
        if (itemPedido.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item pedido não encontrado!");
        }

        service.deletar(itemPedido.get());
        return ResponseEntity.status(HttpStatus.OK).body("Item pedido deletado com sucesso!");
    }
}
