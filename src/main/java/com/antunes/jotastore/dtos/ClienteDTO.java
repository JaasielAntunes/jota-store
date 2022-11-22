package com.antunes.jotastore.dtos;

import com.antunes.jotastore.domain.enums.TipoCliente;
import com.antunes.jotastore.services.validation.ClienteUpdate;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@NoArgsConstructor
@ClienteUpdate
public class ClienteDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "O campo nome não pode ser vazio!")
    @Length(min = 4, max = 30, message = "Deve conter entre 4 e 30 caracteres!")
    private String nome;

    @NotEmpty(message = "O campo email nome não pode ser vazio!")
    @Email(message = "Email inválido!")
    private String email;

    @NotEmpty(message = "O campo cpf ou cnpj não pode ser vazio!")
    private String cpfOuCnpj;

    @NotNull(message = "O campo tipo não pode ser vazio!")
    private Integer tipo;

    public ClienteDTO(String nome, String email, String cpfOuCnpj, TipoCliente tipo) {
        super();
        this.nome = nome;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.tipo = (tipo == null) ? null : tipo.getCod();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public TipoCliente getTipo() {
        return TipoCliente.toEnum(tipo);
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo.getCod();
    }
}
