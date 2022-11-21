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
public class CidadeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "O campo nome não pode ser vazio!")
    @Length(min = 5, max = 20, message = "Deve conter entre 5 e 20 caracteres!")
    private String nome;
}
