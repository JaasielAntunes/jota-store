package com.antunes.jotastore.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@DiscriminatorValue("Pagamento_Cartão")
public class PagamentoComCartao extends Pagamento {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "O campo número de parcelas não pode ser vazio!")
    private Integer numeroDeParcelas;
}
