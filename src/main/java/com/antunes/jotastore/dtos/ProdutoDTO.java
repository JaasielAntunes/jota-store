package com.antunes.jotastore.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProdutoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "O campo nome não pode ser vazio!")
    @Length(min = 4, max = 30, message = "Deve conter entre 4 e 20 caracteres!")
    private String nome;

    @NotEmpty(message = "O campo preço não pode ser vazio!")
    private Double preco;
}
