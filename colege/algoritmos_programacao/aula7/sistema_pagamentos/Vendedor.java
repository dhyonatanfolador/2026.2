
package colege.algoritimos_programacao.aula7.sistema_pagamentos;

public class Vendedor extends Empregado {

    private double comissao;

    public Vendedor(String nome, double comissao) {
        super(nome);
        this.comissao = comissao;

        System.out.println("Criando um vendedor...");
    }

    @Override
    void calcularSalario(double horas, double valorHora) {

        // Calcular o salário pelas horas trabalhadas
        double salarioVendedor = horas * valorHora;

        // Acrescentar a comissão de 8%
        salarioVendedor += salarioVendedor * this.comissao;

        this.setSalario(salarioVendedor);

        System.out.println("Salario atualizado para " + this.getSalario());
    }

}
