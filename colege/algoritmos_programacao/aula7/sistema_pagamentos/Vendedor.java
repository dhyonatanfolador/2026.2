package colege.algoritmos_programacao.aula7.sistema_pagamentos;

public class Vendedor extends Empregado {

    private double comissao;

    public Vendedor(String nome, double comissao) {

        super(nome);

        this.comissao = comissao;

        System.out.println("Criando um vendedor...");
    }

    @Override
    void calcularSalario(double horas, double valorHora) {

        double salarioVendedor = horas * valorHora;

        salarioVendedor += salarioVendedor * this.comissao;

        this.setSalario(salarioVendedor);

        System.out.println("Salario atualizado para " + this.getSalario());
    }

}