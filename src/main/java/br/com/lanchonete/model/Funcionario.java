package br.com.lanchonete.model;

import br.com.lanchonete.util.Mensagens;

import java.time.LocalDate;

public class Funcionario implements IAniversario {

    private final String cpf;
    private final String nome;
    private final String endereco;
    private final String telefone;
    private final LocalDate dataNascimento;
    private Cargo cargo;

    public Funcionario(String cpf, String nome, String endereco, String telefone, LocalDate dataNascimento, Cargo cargo) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public String felizAniversario() {
        return Mensagens.aniversario(getNome(), getDataNascimento());
    }

    @Override
    public String toString() {
        return "Funcionario: " + this.nome;
    }
}
