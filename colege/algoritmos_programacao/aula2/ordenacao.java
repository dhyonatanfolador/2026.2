package colege.algoritmos_programacao.aula2;

import java.util.Arrays;

public class ordenacao {
    public static void main(String[] args) {

        int[] numeros = {50, 10, 40, 20, 30};

        Arrays.sort(numeros);

        System.out.println("Vetor ordenado:");

        for (int numero : numeros) {
            System.out.println(numero);
        }
    }
}
