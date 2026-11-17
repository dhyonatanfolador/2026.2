
package colege.algoritimos_programacao.aula7.sistema_pagamentos;

public class Gerente extends Empregado {

    private double bonus;

    public Gerente(String nome, double bonus) {
        super(nome);
        System.out.println("Criando um gerente...");
    }

    @Override
    void calcularSalario(double horas, double valorHora) {

        // Calcular o bônus
        double salarioGerente = valorHora * horas;

        salarioGerente += salarioGerente * this.bonus;

        this.setSalario(salarioGerente);
    }

}
