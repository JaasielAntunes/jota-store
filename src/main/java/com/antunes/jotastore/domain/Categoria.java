package com.antunes.jotastore.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "O campo nome não pode ser vazio!")
    @Length(min = 4, max = 30, message = "Deve conter entre 4 e 30 caracteres!")
    private String nome;

    @ManyToMany(mappedBy = "categorias")
    private List<Produto> produtos;
}
