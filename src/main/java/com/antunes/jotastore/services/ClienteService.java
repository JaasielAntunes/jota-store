package com.antunes.jotastore.services;

import com.antunes.jotastore.domain.Cliente;
import com.antunes.jotastore.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    @Transactional
    public Cliente cadastrar(Cliente cliente) {
        return repo.save(cliente);
    }

    public Optional<Cliente> buscarPorId(Integer id) {
        return repo.findById(id);
    }

    public Page<Cliente> buscarTodos(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Transactional
    public void deletar(Cliente cliente) {
        repo.delete(cliente);
    }
}
