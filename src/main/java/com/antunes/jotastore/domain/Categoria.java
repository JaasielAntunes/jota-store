package com.antunes.jotastore.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID id;
    private String nome;
}
