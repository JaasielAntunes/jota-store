package com.antunes.jotastore.dtos;

import com.antunes.jotastore.services.validation.ClienteInsert;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@ClienteInsert
public class ClienteNewDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "O campo nome não pode ser vazio!")
    @Length(min = 4, max = 50, message = "Deve conter entre 4 e 50 caracteres!")
    private String nome;

    @NotEmpty(message = "O campo email não pode ser vazio!")
    @Email(message = "Email inválido!")
    private String email;

    @NotEmpty(message = "O campo CPF ou CNPJ não pode ser vazio!")
    private String cpfOuCnpj;

    private Integer tipo;

    private String cep;

    @NotEmpty(message = "O campo logradouro não pode ser vazio!")
    private String logradouro;

    private String bairro;

    @NotEmpty(message = "O campo número não pode ser vazio!")
    private String numero;

    private String complemento;

    @NotEmpty(message = "O campo telefone 1 não pode ser vazio!")
    private String telefone1;

    private String telefone2;

    private Integer cidadeId;

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

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public Integer getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Integer cidadeId) {
        this.cidadeId = cidadeId;
    }
}
