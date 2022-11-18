package com.antunes.jotastore.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EnderecoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "O campo logradouro não pode ser vazio!")
    private String logradouro;

    @NotEmpty(message = "O campo número não pode ser vazio!")
    private String numero;

    @NotEmpty(message = "O campo complemento não pode ser vazio!")
    private String complemento;

    @NotEmpty(message = "O campo bairro não pode ser vazio!")
    private String bairro;

    @NotEmpty(message = "O campo cep não pode ser vazio!")
    private String cep;
}
