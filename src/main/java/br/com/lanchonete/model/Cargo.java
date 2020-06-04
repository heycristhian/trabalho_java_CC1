package br.com.lanchonete.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cargo {

    private long id;
    private String descricao;
    private BigDecimal salario;
    private List<Funcionario> funcionarios = new ArrayList<>();

    private Cargo(Long id, String descricao, BigDecimal salario) {
        this.id = id;
        this.descricao = descricao;
        this.salario = salario;
    }

    @Deprecated
    Cargo() { }

    public static CargoBuilder builder(long id) {
        return new CargoBuilder(id);
    }

    public static class CargoBuilder {
        private long id;
        private String descricao;
        private BigDecimal salario;
        private List<Funcionario> funcionarios = new ArrayList<>();

        private CargoBuilder(long id) {
            this.id = Objects.requireNonNull(id, "O nome é obrigatório!");
        }

        public CargoBuilder withId(long id){
            this.id = Objects.requireNonNull(id, "O nome é obrigatório!");
            return this;
        }

        public CargoBuilder withDescricao(String descricao) {
            this.descricao = Objects.requireNonNull(descricao, "A descrição do cargo é obrigatório!");
            return this;
        }

        public CargoBuilder withSalario(BigDecimal salario) throws IllegalArgumentException {
            if (salario.compareTo(BigDecimal.ZERO) > 0){
                this.salario = Objects.requireNonNull(salario, "O salário do cargo é obrigatório!");
                return this;
            }
            throw new IllegalArgumentException("O salário tem que ser um valor positivo!");
        }

        public Cargo build() {
            Objects.requireNonNull(id, "Id é obrigatório");
            Objects.requireNonNull(descricao, "Descricao é obrigatório");
            Objects.requireNonNull(salario, "Salario é obrigatório");
            return new Cargo(id, descricao, salario);
        }
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        getFuncionarios().add(funcionario);
    }
}
