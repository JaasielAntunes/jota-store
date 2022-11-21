package com.antunes.jotastore.dtos;

import com.antunes.jotastore.domain.enums.EstadoPagamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PagamentoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private EstadoPagamento estado;
}
