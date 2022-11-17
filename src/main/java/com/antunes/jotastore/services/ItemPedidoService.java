package com.antunes.jotastore.services;

import com.antunes.jotastore.domain.ItemPedido;
import com.antunes.jotastore.repositories.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository repo;

    @Transactional
    public ItemPedido cadastrar(ItemPedido itemPedido) {
        return repo.save(itemPedido);
    }

    public Optional<ItemPedido> buscarPorId(Integer id) {
        return repo.findById(id);
    }

    public Page<ItemPedido> buscarTodos(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Transactional
    public void deletar(ItemPedido itemPedido) {
        repo.delete(itemPedido);
    }
}
