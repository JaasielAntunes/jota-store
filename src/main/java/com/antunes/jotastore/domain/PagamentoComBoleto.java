package com.antunes.jotastore.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@DiscriminatorValue("Pagamento_Boleto")
public class PagamentoComBoleto extends Pagamento {

    private static final long serialVersionUID = 1L;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataDeVencimento;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataDePagamento;
}
