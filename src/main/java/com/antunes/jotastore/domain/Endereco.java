package com.antunes.jotastore.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "O campo logradouro não pode ser vazio!")
    @Size(max = 20, message = "Tamanho inválido!")
    private String logradouro;

    @NotEmpty(message = "O campo número não pode ser vazio!")
    @Size(max = 5, message = "Tamanho inválido!")
    private String numero;

    private String complemento;

    @NotEmpty(message = "O campo bairro não pode ser vazio!")
    @Size(max = 15, message = "Tamanho inválido!")
    private String bairro;

    @NotEmpty(message = "O campo cep não pode ser vazio!")
    @Size(max = 9, message = "Tamanho inválido! Formato > 00000-000")
    private String cep;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;
}
