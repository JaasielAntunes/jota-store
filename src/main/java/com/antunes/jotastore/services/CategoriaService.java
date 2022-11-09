package com.antunes.jotastore.services;

import com.antunes.jotastore.domain.Categoria;
import com.antunes.jotastore.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    @Transactional
    public Categoria cadastrar(Categoria categoria) {
        return repo.save(categoria);
    }

    public Optional<Categoria> buscarPorId(Integer id) {
        return repo.findById(id);
    }

    public Page<Categoria> buscarTodos(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Transactional
    public void deletar(Categoria categoria) {
        repo.delete(categoria);
    }
}
