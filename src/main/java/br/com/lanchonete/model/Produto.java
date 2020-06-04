package br.com.lanchonete.model;

import java.math.BigDecimal;

public class Produto {

    private final String descricao;
    private final BigDecimal valor;
    private final Long quantidade;
    private final Boolean produz;

    public Produto(String descricao, BigDecimal valor, Long quantidade, Boolean produz) {
        this.descricao = descricao;
        this.valor = valor;
        this.quantidade = quantidade;
        this.produz = produz;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Boolean getProduz() {
        return produz;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "descricao='" + descricao + '\'' +
                '}';
    }
}
