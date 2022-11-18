package com.antunes.jotastore.dtos;

import com.antunes.jotastore.domain.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoriaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Campo nome não pode ser vazio!")
    @Length(min = 4, max = 30, message = "Deve conter entre 4 a 30 caracteres!")
    private String nome;

    private CategoriaDTO(Categoria obj) {
        id = obj.getId();
        nome = obj.getNome();
    }
}
