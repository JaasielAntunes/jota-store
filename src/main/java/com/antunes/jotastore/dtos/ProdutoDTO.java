package com.antunes.jotastore.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProdutoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "O campo nome não pode ser vazio!")
    @Size(max = 40, message = "Tamanho inválido!")
    private String nome;

    @NotEmpty(message = "O campo preço não pode ser vazio!")
    private Double preco;
}
