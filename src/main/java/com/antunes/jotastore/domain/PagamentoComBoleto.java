package com.antunes.jotastore.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@DiscriminatorValue("Pagamento_Boleto")
public class PagamentoComBoleto extends Pagamento {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "O campo data de vencimento não pode ser vazio!")
    @Size(max = 10, message = "Tamanho inválido!")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataDeVencimento;

    @NotNull(message = "O campo data de pagamento não pode ser vazio!")
    @Size(max = 10, message = "Tamanho inválido!")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataDePagamento;
}
