package br.com.lanchonete.main;

import br.com.lanchonete.model.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Cargo cargo = Cargo.builder(1L)
                //.withId(1L)
                .withDescricao("Garçom")
                .withSalario(BigDecimal.valueOf(1500.0))
                .build();

        //CRIAÇÃO DE PRODUTOS
        Produto produto1 = new Produto(
                "Hot-Dog Duplo",
                BigDecimal.valueOf(13.5),
                1L,
                true);

        Produto produto2 = new Produto(
                "Coca-Cola Zero 2L",
                BigDecimal.valueOf(7.90),
                1L,
                false);

        Produto produto3 = new Produto(
                "Fanta 2L",
                BigDecimal.valueOf(7.90),
                1L,
                false);

        Produto produto4 = new Produto(
                "X-Tudo",
                BigDecimal.valueOf(15.60),
                1L,
                true);

        Cliente cliente = new Cliente(
                "45073070828",
                "Cristhian Dias",
                "José Conceição, 26",
                "18997415398", LocalDate.of(1995, 9, 5));

        Funcionario funcionario1 = new Funcionario(
                "11011011011",
                "João V. Franco",
                "Rua dos Programadores",
                "1899999999",
                LocalDate.of(1990, 4, 12), cargo);

        Funcionario funcionario2 = new Funcionario(
                "11011011011",
                "José da Silva",
                "Rua dos Programadores",
                "1899999999",
                LocalDate.of(1990, 4, 12), cargo);

        cargo.adicionarFuncionario(funcionario1);
        cargo.adicionarFuncionario(funcionario2);

        //funcionario1.criarPedido(cliente)
        Pedido pedido1 = new Pedido(cliente, funcionario1);
        Pedido pedido2 = new Pedido(cliente, funcionario2);

        //Funcionario tbm cria os produtos do pedido
        pedido1.adicionarLista(Arrays.asList(produto1, produto2));
        pedido2.adicionarLista(Arrays.asList(produto3, produto4));

        cliente.adicionarPedidos(pedido1);
        cliente.adicionarPedidos(pedido2);

        cliente.imprimirPedidos();

        System.out.println("Todos os produtos do pedido 1: ");
        pedido1.getProdutos().forEach(produto -> System.out.println(produto.getDescricao()));
        System.out.println();
        System.out.println("Todos os produtos do pedido 2: ");
        pedido2.getProdutos().forEach(produto -> System.out.println(produto.getDescricao()));
    }
}
