package com.antunes.jotastore.dtos;

import com.antunes.jotastore.domain.enums.TipoCliente;
import com.antunes.jotastore.services.validation.ClienteInsert;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ClienteInsert
public class ClienteNewDTO implements Serializable {

    private static final long serialVersionUID = 1L;

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

    @NotEmpty(message = "O campo telefone 1 não pode ser vazio!")
    private String telefone1;

    private String telefone2;

    private Integer cidadeId;

    public TipoCliente getTipo() {
        return TipoCliente.toEnum(tipo);
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo.getCod();
    }
}
