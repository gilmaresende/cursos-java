package io.github.cursodsousa.msclientes.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private String nome;
    private String idade;

    public Cliente(String cpf, String nome, String idade) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
    }
}