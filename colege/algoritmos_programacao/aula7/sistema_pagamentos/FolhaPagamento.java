
/*
Na empresa XYZ os empregados têm matrícula, nome e salário.
O salário é calculado pelas horas trabalhadas e o valor da hora.

Criar um programa para calcular o salário da turma.

Obs.: o gerente ganha um bônus de 30%.
O vendedor ganha uma comissão adicional de 8% sobre a venda do mês.
*/

package com.mycompany.projetoFolhaPagamento;

import java.util.ArrayList;
import java.util.Iterator;

public class FolhaPagamento {

    public static void main(String[] args) {

        // Todo o sistema será baseado em um ArrayList de objetos "Empregado"
        ArrayList<Empregado> empregados;
        empregados = new ArrayList<>();

        System.out.println("Sistema de Folha de Pagamento 1.0");

        // Criando um empregado padrão
        Empregado ep = new EmpregadoPadrao("Jacir Oliveira");

        ep.mostrarEmpregado();

        ep.calcularSalario(44, 59.33);

        ep.mostrarEmpregado();

        // Vamos criar um gerente
        Empregado gerente = new Gerente("Sr. Farias", 0.35);

        gerente.calcularSalario(40, 89.90);

        // Vamos colocar os empregados no ArrayList
        empregados.add(ep);
        empregados.add(gerente);

        System.out.println("Qtde empregados: " + empregados.size());

        // Agora vamos mostrar os objetos dentro do ArrayList

        // Forma 1 - Com Iterator
        // O iterador chamado "pegador" vai interagir
        // no ArrayList de empregados.

        Iterator<Empregado> pegador = empregados.iterator();

        while (pegador.hasNext()) {

            Empregado emp = pegador.next();

            emp.mostrarEmpregado();
        }

        // Forma 2 - Com Foreach
        System.out.println("Mostrando os empregados 2: \n");

        for (Empregado emp : empregados) {

            emp.mostrarEmpregado();
        }

        // Forma 3 - Com Expressões Lambda
        System.out.println("Mostrando os empregados 3: \n");

        empregados.forEach(emp -> emp.mostrarEmpregado());

    }
}

// Exercício de continuidade:
// Implementar o vendedor e criar um menu de cadastro
// de empregados aqui no main.
