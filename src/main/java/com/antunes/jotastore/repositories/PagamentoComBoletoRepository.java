package com.antunes.jotastore.repositories;

import com.antunes.jotastore.domain.PagamentoComBoleto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoComBoletoRepository extends JpaRepository<PagamentoComBoleto, Integer> {

}
