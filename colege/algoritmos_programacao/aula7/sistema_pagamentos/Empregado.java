package colege.algoritmos_programacao.aula7.sistema_pagamentos;

import java.io.PrintStream;

public abstract class Empregado implements Validador {

    private int matricula;
    private String nome;
    private double salario;

    private static int contMatricula = 1000;

    public Empregado(String nome) {
        this.nome = nome;
        this.matricula = contMatricula++;

        System.out.println("Criou o funcionário " + this.matricula);
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void mostrarEmpregado() {

        System.out.println("Dados do Empregado: ");
        System.out.println("------------------------------");
        System.out.println("MATRICULA  |  NOME  |  SALARIO");

        System.out.println("------------------------------");

        PrintStream saida = System.out;

        saida.println(
            getMatricula() + " - " +
            getNome() + " - " +
            getSalario()
        );

        System.out.println("------------------------------");
    }

    @Override
    public boolean validarSalario() {
        return salario > 0;
    }

    abstract void calcularSalario(double horas, double valorHora);
}