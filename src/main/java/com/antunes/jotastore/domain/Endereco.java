package com.antunes.jotastore.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    @NotNull(message = "O campo logradouro não pode ser vazio!")
    @Size(max = 20, message = "Tamanho inválido!")
    private String logradouro;

    @NotNull(message = "O campo número não pode ser vazio!")
    @Size(max = 5, message = "Tamanho inválido!")
    private String numero;

    @NotNull(message = "O campo complemento não pode ser vazio!")
    @Size(max = 15, message = "Tamanho inválido!")
    private String complemento;

    @NotNull(message = "O campo bairro não pode ser vazio!")
    @Size(max = 15, message = "Tamanho inválido!")
    private String bairro;

    @NotNull(message = "O campo cep não pode ser vazio!")
    @Size(max = 10, message = "Tamanho inválido!")
    private String cep;

    @JsonBackReference // não pode serializar o cliente
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;
}
