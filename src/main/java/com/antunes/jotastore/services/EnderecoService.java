package com.antunes.jotastore.services;

import com.antunes.jotastore.domain.Endereco;
import com.antunes.jotastore.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repo;

    @Transactional
    public Endereco cadastrar(Endereco endereco) {
        return repo.save(endereco);
    }

    public Optional<Endereco> buscarPorId(Integer id) {
        return repo.findById(id);
    }

    public Page<Endereco> buscarTodos(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Transactional
    public void deletar(Endereco endereco) {
        repo.delete(endereco);
    }
}
