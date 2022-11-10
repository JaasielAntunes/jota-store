package com.antunes.jotastore.domain;

import com.antunes.jotastore.domain.enums.TipoCliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    @NotNull(message = "O campo nome não pode ser vazio!")
    @Size(max = 40)
    private String nome;

    @NotNull(message = "O email nome não pode ser vazio!")
    @Email(message = "Email inválido!")
    @Size(max = 30)
    private String email;

    @NotNull(message = "O campo cpf ou cnpj não pode ser vazio!")
    @Size(max = 20)
    private String cpfOuCnpj;

    private Integer tipo;

    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos;

    @ElementCollection
    @CollectionTable(name = "TELEFONE")
    private Set<String> telefones;

    public Cliente(TipoCliente tipo) {
        this.tipo = tipo.getCod();
    }

    public TipoCliente getTipo() { // armazenar internamente o número inteiro
        return TipoCliente.toEnum(tipo);
    }

    public void setTipo(TipoCliente tipo) { // retornar apenas o código
        this.tipo = tipo.getCod();
    }
}
