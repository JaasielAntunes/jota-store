package com.antunes.jotastore.services;

import com.antunes.jotastore.domain.Estado;
import com.antunes.jotastore.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository repo;

    @Transactional
    public Estado cadastrar(Estado estado) {
        return repo.save(estado);
    }

    public Optional<Estado> buscarPorId(Integer id) {
        return repo.findById(id);
    }

    public Page<Estado> buscarTodos(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Transactional
    public void deletar(Estado estado) {
        repo.delete(estado);
    }
}
