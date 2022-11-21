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
public class EnderecoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "O campo logradouro não pode ser vazio!")
    @Length(min = 5, max = 20, message = "Deve conter entre 5 e 20 caracteres!")
    private String logradouro;

    @NotEmpty(message = "O campo número não pode ser vazio!")
    @Length(min = 1, max = 4, message = "Deve conter entre 1 e 4 caracteres!")
    private String numero;

    private String complemento;

    @NotEmpty(message = "O campo bairro não pode ser vazio!")
    @Length(min = 4, max = 15, message = "Deve conter entre 4 e 15 caracteres!")
    private String bairro;

    @NotEmpty(message = "O campo cep não pode ser vazio!")
    @Length(min = 9, max = 9, message = "Deve conter 9 caracteres! (00000-000)")
    private String cep;
}
