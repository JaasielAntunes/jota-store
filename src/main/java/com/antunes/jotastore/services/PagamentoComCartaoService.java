package com.antunes.jotastore.services;

import com.antunes.jotastore.domain.PagamentoComCartao;
import com.antunes.jotastore.repositories.PagamentoComCartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class PagamentoComCartaoService {

    @Autowired
    private PagamentoComCartaoRepository repo;

    @Transactional
    public PagamentoComCartao cadastrar(PagamentoComCartao pagamentoComCartao) {
        return repo.save(pagamentoComCartao);
    }

    public Optional<PagamentoComCartao> buscarPorId(Integer id) {
        return repo.findById(id);
    }

    public Page<PagamentoComCartao> buscarTodos(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Transactional
    public void deletar(PagamentoComCartao pagamentoComCartao) {
        repo.delete(pagamentoComCartao);
    }
}
