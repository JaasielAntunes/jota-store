package com.antunes.jotastore.repositories;

import com.antunes.jotastore.domain.PagamentoComCartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoComCartaoRepository extends JpaRepository<PagamentoComCartao, Integer> {

}
