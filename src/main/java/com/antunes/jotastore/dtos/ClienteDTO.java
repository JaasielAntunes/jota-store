package com.antunes.jotastore.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClienteDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "O campo nome não pode ser vazio!")
    @Length(min = 4, max = 30, message = "Deve conter entre 4 e 30 caracteres!")
    private String nome;

    @NotEmpty(message = "O campo email nome não pode ser vazio!")
    @Email(message = "Email inválido!")
    private String email;

    @NotEmpty(message = "O campo cpf ou cnpj não pode ser vazio!")
    private String cpfOuCnpj;
}
