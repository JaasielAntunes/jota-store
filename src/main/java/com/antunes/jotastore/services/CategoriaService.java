package com.antunes.jotastore.services;

import com.antunes.jotastore.domain.Categoria;
import com.antunes.jotastore.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CategoriaService {

    private CategoriaRepository repo;

    public Optional<Categoria> buscar(UUID id) {
        return repo.findById(id);
    }
}
