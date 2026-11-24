package colege.algoritmos_programacao.aula2;

public class bubbleSort {
    public static void ordenar(int[] numeros) {

        for (int i = 0; i < numeros.length - 1; i++) {

            for (int j = 0; j < numeros.length - 1 - i; j++) {

                if (numeros[j] > numeros[j + 1]) {

                    int temp = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] numeros = {50, 20, 40, 10, 30};

        ordenar(numeros);

        System.out.println("Vetor ordenado:");

        for (int numero : numeros) {
            System.out.println(numero);
        }
    }
}
