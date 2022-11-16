package com.antunes.jotastore.services;

import com.antunes.jotastore.domain.Pagamento;
import com.antunes.jotastore.repositories.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository repo;

    @Transactional
    public Pagamento cadastrar(Pagamento pagamento) {
        return repo.save(pagamento);
    }

    public Optional<Pagamento> buscarPorId(Integer id) {
        return repo.findById(id);
    }

    public Page<Pagamento> buscarTodos(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Transactional
    public void deletar(Pagamento pagamento) {
        repo.delete(pagamento);
    }
}
