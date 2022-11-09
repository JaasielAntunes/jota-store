package com.antunes.jotastore.services;

import com.antunes.jotastore.domain.Produto;
import com.antunes.jotastore.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repo;

    @Transactional
    public Produto cadastrar(Produto produto) {
        return repo.save(produto);
    }

    public Optional<Produto> buscarPorId(Integer id) {
        return repo.findById(id);
    }

    public Page<Produto> buscarTodos(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Transactional
    public void deletar(Produto produto) {
        repo.delete(produto);
    }
}
