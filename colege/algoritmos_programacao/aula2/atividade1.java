package colege.algoritmos_programacao.aula2;

import java.util.Scanner;

public class atividade1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[] numeros = new int[10];

        for (int i = 0; i < 10; i++) {
            System.out.print("Digite o " + (i + 1) + "º número: ");
            numeros[i] = scanner.nextInt();
        }

        System.out.println("\nNúmeros digitados:");

        for (int i = 0; i < 10; i++) {
            System.out.println(numeros[i]);
        }
    }
}
