package com.antunes.jotastore.services;

import com.antunes.jotastore.domain.Pedido;
import com.antunes.jotastore.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    @Transactional
    public Pedido cadastrar(Pedido pedido) {
        return repo.save(pedido);
    }

    public Optional<Pedido> buscarPorId(Integer id) {
        return repo.findById(id);
    }

    public Page<Pedido> buscarTodos(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Transactional
    public void deletar(Pedido pedido) {
        repo.delete(pedido);
    }
}
