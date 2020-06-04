package br.com.lanchonete.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pedido {

    private final LocalDateTime dataHora = LocalDateTime.now();
    private Cliente cliente;
    private Funcionario funcionario;
    private BigDecimal valorTotal = BigDecimal.ZERO;
    private StatusPedido status = StatusPedido.ABERTO;
    private List<Produto> produtos = new ArrayList<>();

    public Pedido(Cliente cliente, Funcionario funcionario) {
        this.cliente = cliente;
        this.funcionario = funcionario;
    }

    public List<Produto> getProdutos() {
        return Collections.unmodifiableList(produtos);
    }

    public void adicionarLista(List<Produto> produtos) {
        this.produtos = produtos;
        produtos.forEach(produto -> this.valorTotal = this.valorTotal.add(produto.getValor()));

        produtos.stream().filter(Produto::getProduz).findAny()
            .ifPresentOrElse(produto -> {
                geraStatus(StatusPedido.PRODUCAO);
            }, () -> {
                geraStatus(StatusPedido.SAIU_PARA_ENTREGA);
            });
    }


    public void geraStatus(StatusPedido status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pedido { " + "\n" +
                "dataHora: " + dataHora + "\n" +
                cliente + "\n" +
                funcionario + "\n" +
                "valorTotal: " + valorTotal + "\n" +
                "status: " + status + "\n" +
                "produtos: " + produtos + "\n" +
                '}';
    }
}
