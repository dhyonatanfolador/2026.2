
package colege.algoritimos_programacao.aula7.sistema_pagamentos;

public abstract class Empregado {

    private int matricula;
    private String nome;
    private double salario;

    // Sempre que criar um funcionário, receberá um código automático
    private static int contMatricula = 1000;

    // O static torna a variável contMatricula compartilhada entre todos os objetos

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

        System.out.println(this.getMatricula() + " - "
                + this.getNome() + " - "
                + this.getSalario());

        System.out.println("------------------------------");
    }

    abstract void calcularSalario(double horas, double valorHora);

}
