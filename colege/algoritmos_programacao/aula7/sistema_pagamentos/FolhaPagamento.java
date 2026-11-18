package colege.algoritmos_programacao.aula7.sistema_pagamentos;

import java.util.ArrayList;
import java.util.Scanner;

public class FolhaPagamento {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        ArrayList<Empregado> empregados = new ArrayList<>();

        int opcao;

        do {

            System.out.println("\n===== SISTEMA DE FOLHA DE PAGAMENTO =====");
            System.out.println("1 - Cadastrar empregado padrão");
            System.out.println("2 - Cadastrar gerente");
            System.out.println("3 - Cadastrar vendedor");
            System.out.println("4 - Listar empregados");
            System.out.println("5 - Sair");

            System.out.print("Escolha uma opção: ");

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {

                case 1:

                    System.out.print("Nome: ");
                    String nome = entrada.nextLine();

                    System.out.print("Horas trabalhadas: ");
                    double horas = entrada.nextDouble();

                    System.out.print("Valor da hora: ");
                    double valorHora = entrada.nextDouble();

                    EmpregadoPadrao ep = new EmpregadoPadrao(nome);

                    ep.calcularSalario(horas, valorHora);

                    if (ep.validarSalario()) {

                        empregados.add(ep);

                        System.out.println("Empregado cadastrado com sucesso!");

                    } else {

                        System.out.println("Salario invalido! Empregado nao cadastrado.");

                    }

                    break;

                case 2:

                    System.out.print("Nome do gerente: ");
                    nome = entrada.nextLine();

                    System.out.print("Horas trabalhadas: ");
                    horas = entrada.nextDouble();

                    System.out.print("Valor da hora: ");
                    valorHora = entrada.nextDouble();

                    Gerente gerente = new Gerente(nome, 0.30);

                    gerente.calcularSalario(horas, valorHora);

                    if (gerente.validarSalario()) {

                        empregados.add(gerente);

                        System.out.println("Gerente cadastrado com sucesso!");

                    } else {

                        System.out.println("Salario invalido! Gerente nao cadastrado.");

                    }

                    break;

                case 3:

                    System.out.print("Nome do vendedor: ");
                    nome = entrada.nextLine();

                    System.out.print("Horas trabalhadas: ");
                    horas = entrada.nextDouble();

                    System.out.print("Valor da hora: ");
                    valorHora = entrada.nextDouble();

                    System.out.print("Total de vendas no mês: ");
                    double vendas = entrada.nextDouble();

                    Vendedor vendedor = new Vendedor(nome, 0.08);

                    vendedor.calcularSalario(horas, valorHora);

                    if (vendedor.validarSalario()) {

                        empregados.add(vendedor);

                        System.out.println("Vendedor cadastrado com sucesso!");

                    } else {

                        System.out.println("Salario invalido! Vendedor nao cadastrado.");

                    }

                    break;

                case 4:

                    System.out.println("\n===== EMPREGADOS CADASTRADOS =====");

                    if (empregados.isEmpty()) {

                        System.out.println("Nenhum empregado cadastrado!");

                    } else {

                        for (Empregado emp : empregados) {

                            emp.mostrarEmpregado();

                        }
                    }

                    break;

                case 5:

                    System.out.println("Encerrando o sistema...");

                    break;

                default:

                    System.out.println("Opcao invalida!");

            }

        } while (opcao != 5);

        entrada.close();
    }
}