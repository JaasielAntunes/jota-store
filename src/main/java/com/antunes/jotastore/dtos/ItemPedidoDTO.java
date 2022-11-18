package com.antunes.jotastore.dtos;

import com.antunes.jotastore.domain.ItemPedidoPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemPedidoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @EmbeddedId
    private ItemPedidoPK id = new ItemPedidoPK();

    @NotEmpty(message = "O campo quantidade não pode ser vazio!")
    private Integer quantidade;

    @NotEmpty(message = "O campo desconto não pode ser vazio!")
    private Double desconto;

    @NotEmpty(message = "O campo preço não pode ser vazio!")
    private Double preco;
}
