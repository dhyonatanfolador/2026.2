package colege.algoritmos_programacao.aula7.sistema_pagamentos;

public class EmpregadoPadrao extends Empregado {

    public EmpregadoPadrao(String nome) {
        super(nome);

        System.out.println("Criando um empregado padrao...");
    }

    @Override
    void calcularSalario(double horas, double valorHora) {

        double salario = horas * valorHora;

        this.setSalario(salario);

        System.out.println("Salario atualizado para " + this.getSalario());
    }

}