package br.com.lanchonete.model;

import br.com.lanchonete.util.Mensagens;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.*;

public class Cliente implements IAniversario {

    private final String cpf;
    private final String nome;
    private final String endereco;
    private final String telefone;
    private final LocalDate dataNascimento;
    private Map<Cliente, List<Pedido>> pedidos = new LinkedHashMap<>();

    public Cliente(String cpf, String nome, String endereco, String telefone, LocalDate dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Map<Cliente, List<Pedido>> getPedidos() {
        return pedidos;
    }

    public void adicionarPedidos (Pedido pedido) {
        Objects.requireNonNull(this, "Cliente não pode ser nulo");
        Objects.requireNonNull(pedido, "Pedido não pode ser nulo");

        List<Pedido> pedidos = Optional.ofNullable(this.pedidos.get(this)).orElse(new LinkedList<>());
        pedidos.add(pedido);
        this.pedidos.put(this, pedidos);
    }

    @Override
    public String felizAniversario() {
        return Mensagens.aniversario(getNome(), getDataNascimento());
    }

    public void imprimirPedidos() {
        System.out.println("Produtos do cliente: " + this.getNome());
        getPedidos().get(this).forEach(pedido -> System.out.println(pedido));
    }

    @Override
    public String toString() {
        return "Cliente: " + this.nome;
    }
}
