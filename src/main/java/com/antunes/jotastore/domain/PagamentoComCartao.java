package com.antunes.jotastore.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@DiscriminatorValue("Pagamento_Cartão")
public class PagamentoComCartao extends Pagamento {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "O campo número de parcelas não pode ser vazio!")
    @Size(max = 2, message = "Tamanho inválido!")
    private Integer numeroDeParcelas;
}
