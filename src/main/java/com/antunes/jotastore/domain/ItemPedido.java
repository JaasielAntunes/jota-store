package com.antunes.jotastore.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class ItemPedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @EmbeddedId
    private ItemPedidoPK id = new ItemPedidoPK();

    @NotNull(message = "O campo quantidade não pode ser vazio!")
    @Size(max = 10, message = "Tamanho inválido!")
    private Integer quantidade;

    @NotNull(message = "O campo desconto não pode ser vazio!")
    @Size(max = 3, message = "Tamanho inválido!")
    private Double desconto;

    @NotNull(message = "O campo preço não pode ser vazio!")
    @Size(max = 6, message = "Tamanho inválido!")
    private Double preco;

    @JsonIgnore
    public Pedido getPedido() {
        return id.getPedido();
    }

    public Produto getProduto() {
        return id.getProduto();
    }
}
