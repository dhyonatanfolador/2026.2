package colege.algoritmos_programacao.aula7.sistema_pagamentos;

public class Gerente extends Empregado {

    private double bonus;

    public Gerente(String nome, double bonus) {

        super(nome);

        this.bonus = bonus;

        System.out.println("Criando um gerente...");
    }

    @Override
    void calcularSalario(double horas, double valorHora) {

        double salarioGerente = horas * valorHora;

        salarioGerente += salarioGerente * this.bonus;

        this.setSalario(salarioGerente);

        System.out.println("Salario atualizado para " + this.getSalario());
    }

}