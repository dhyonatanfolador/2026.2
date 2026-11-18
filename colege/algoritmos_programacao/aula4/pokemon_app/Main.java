package colege.algoritmos_programacao.aula4.pokemon_app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Pokemon[] arena = new Pokemon[2];

        // Criando os dois Pokemons
        arena[0] = new Pokemon("Pikachu", 100, 20);
        arena[1] = new Pokemon("Charmander", 100, 15);

        // Cadastrando os golpes do Pikachu
        arena[0].novoGolpe(0, new Golpe("Choque do Trovao", 30));
        arena[0].novoGolpe(1, new Golpe("Ataque Rapido", 20));
        arena[0].novoGolpe(2, new Golpe("Cauda de Ferro", 25));

        // Cadastrando os golpes do Charmander
        arena[1].novoGolpe(0, new Golpe("Brasas", 25));
        arena[1].novoGolpe(1, new Golpe("Arranhao Camaleao", 20));
        arena[1].novoGolpe(2, new Golpe("Lanca-Chamas", 35));

        int jogadorAtual = 0;

        System.out.println("--- A SUPER BATALHA POKEMON V. 0.2 ---");

        // Loop principal da batalha
        while (arena[0].estaVivo() && arena[1].estaVivo()) {

            // Define quem vai atacar e quem vai receber o ataque
            Pokemon atacante = arena[jogadorAtual];
            Pokemon adversario = arena[1 - jogadorAtual];

            System.out.println("\n------------------------");

            // Mostra o status dos dois Pokemons
            atacante.mostrarStatus();
            adversario.mostrarStatus();

            // Mostra os golpes disponiveis
            atacante.mostrarGolpes();

            // Pede ao jogador que escolha um golpe
            System.out.print("Escolha o golpe (0 a 2): ");
            int golpe = teclado.nextInt();

            // Executa o ataque escolhido
            atacante.atacar(adversario, golpe);

            System.out.println();

            // Mostra a vida do adversario depois do ataque
            adversario.mostrarStatus();

            // Verifica se o adversario foi derrotado
            if (!adversario.estaVivo()) {
                System.out.println(
                    "\n" + atacante.nome + " venceu a batalha!"
                );
                break;
            }

            System.out.println(
                "\nEsse golpe nao finalizou a batalha! Vamos em frente...\n"
            );

            // Passa a vez para o outro jogador
            if (jogadorAtual == 0) {
                jogadorAtual = 1;
            } else {
                jogadorAtual = 0;
            }
        }

        // Fecha o Scanner ao terminar a batalha
        teclado.close();
    }
}