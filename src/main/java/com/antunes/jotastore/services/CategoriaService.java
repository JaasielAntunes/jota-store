package com.antunes.jotastore.services;

import com.antunes.jotastore.domain.Categoria;
import com.antunes.jotastore.repositories.CategoriaRepository;
import com.antunes.jotastore.services.exceptions.DataIntegrityException;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
    public void deletar(Integer id) {
        buscarPorId(id);

        try {
            repo.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos!");
        }
    }
}
