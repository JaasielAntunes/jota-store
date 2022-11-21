package com.antunes.jotastore.domain;

import com.antunes.jotastore.domain.enums.TipoCliente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "O campo nome não pode ser vazio!")
    @Length(min = 4, max = 50, message = "Deve conter entre 4 e 50 caracteres!")
    private String nome;

    @NotEmpty(message = "O campo email nome não pode ser vazio!")
    @Email(message = "Email inválido!")
    private String email;

    @NotEmpty(message = "O campo CPF ou CNPJ não pode ser vazio!")
    private String cpfOuCnpj;

    @NotNull(message = "O campo tipo não pode ser vazio!")
    @Range(min = 1, max = 2, message = "Informe apenas tipo 1 ou 2!")
    private Integer tipo;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Endereco> enderecos;

    @ElementCollection
    @CollectionTable(name = "TELEFONE")
    private Set<String> telefones;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;

    public TipoCliente getTipo() {
        return TipoCliente.toEnum(tipo);
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo.getCod();
    }
}
