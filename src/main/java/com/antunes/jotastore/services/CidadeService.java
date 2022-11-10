package com.antunes.jotastore.services;

import com.antunes.jotastore.domain.Cidade;
import com.antunes.jotastore.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository repo;

    @Transactional
    public Cidade cadastrar(Cidade cidade) {
        return repo.save(cidade);
    }

    public Optional<Cidade> buscarPorId(Integer id) {
        return repo.findById(id);
    }

    public Page<Cidade> buscarTodos(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Transactional
    public void deletar(Cidade cidade) {
        repo.delete(cidade);
    }
}
