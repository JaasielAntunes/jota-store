package com.antunes.jotastore.services;

import com.antunes.jotastore.domain.PagamentoComBoleto;
import com.antunes.jotastore.repositories.PagamentoComBoletoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class PagamentoComBoletoService {

    @Autowired
    private PagamentoComBoletoRepository repo;

    @Transactional
    public PagamentoComBoleto cadastrar(PagamentoComBoleto pagamentoComBoleto) {
        return repo.save(pagamentoComBoleto);
    }

    public Optional<PagamentoComBoleto> buscarPorId(Integer id) {
        return repo.findById(id);
    }

    public Page<PagamentoComBoleto> buscarTodos(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Transactional
    public void deletar(PagamentoComBoleto pagamentoComBoleto) {
        repo.delete(pagamentoComBoleto);
    }
}
