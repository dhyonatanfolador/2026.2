package pokemon_app;

import java.util.Random;

public class Pokemon {
    // Atributos do Pokemon
    String nome;
    int pontosVida, poderAtaque;

    // Array que armazena ate 3 golpes
    Golpe[] golpes;

    // Construtor: define os dados iniciais do Pokemon
    public Pokemon(String nome, int pontosVida, int poderAtaque) {
        this.nome = nome;
        this.pontosVida = pontosVida;
        this.poderAtaque = poderAtaque;

        // Cria um array para armazenar 3 golpes
        this.golpes = new Golpe[3];
    }

    // Adiciona um golpe em uma posicao do array
    void novoGolpe(int posicao, Golpe golpe) {
        golpes[posicao] = golpe;
    }

    // Mostra os golpes cadastrados do Pokemon
    void mostrarGolpes() {
        System.out.println("Golpes de " + nome + ":");

        // Percorre todas as posicoes do array
        for (int i = 0; i < golpes.length; i++) {

            // Verifica se existe um golpe na posicao
            if (golpes[i] != null) {
                System.out.println(
                    i + " - " + golpes[i].nome +
                    " (dano maximo: " + golpes[i].dano + ")"
                );
            }
        }
    }

    // Ataca outro Pokemon usando um dos golpes cadastrados
    void atacar(Pokemon adversario, int numeroGolpe) {

        // Seleciona o golpe escolhido
        Golpe golpeEscolhido = golpes[numeroGolpe];

        // Cria um gerador de numeros aleatorios
        Random random = new Random();

        // Calcula um dano aleatorio entre 1 e o dano maximo
        int danoReal = random.nextInt(golpeEscolhido.dano) + 1;

        // Mostra as informacoes do ataque
        System.out.println();
        System.out.println(nome + " usou " + golpeEscolhido.nome + "!");
        System.out.println("O ataque causou " + danoReal + " de dano!");

        // Diminui a vida do adversario
        adversario.pontosVida -= danoReal;

        // Impede que a vida fique negativa
        if (adversario.pontosVida < 0) {
            adversario.pontosVida = 0;
        }
    }

    // Verifica se o Pokemon ainda esta vivo
    boolean estaVivo() {
        return pontosVida > 0;
    }

    // Mostra o nome e a vida atual do Pokemon
    void mostrarStatus() {
        System.out.println(nome + " - Vida: " + pontosVida);
    }
}