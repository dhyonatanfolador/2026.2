import java.util.Scanner;

public class Main {

    static Scanner entrada = new Scanner(System.in);

    // Espera um tempo (em milissegundos)
    static void esperar(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Escreve uma linha e dá uma pausa antes da próxima
    static void escrever(String texto) {
        System.out.println(texto);
        esperar(800);
    }

    // Espera o jogador apertar ENTER
    static void continuar() {
        System.out.print("\n[ENTER para continuar] ");
        entrada.nextLine();
        System.out.println();
    }

    static void batalha(Jogador jogador, Criatura criatura) {
        int turno = 1;

        while (jogador.vida.estaViva() && criatura.vida.estaViva()) {
            System.out.println("--- Turno " + turno + " ---");
            System.out.println("Sua vida: " + jogador.vida.pontos
                    + " | " + criatura.nome + ": " + criatura.vida.pontos);
            System.out.print("[ENTER para atacar] ");
            entrada.nextLine();

            jogador.ataque.atacar(criatura.vida);
            escrever("Você atacou e causou " + jogador.ataque.dano + " de dano!");

            if (!criatura.vida.estaViva()) {
                break;
            }

            esperar(500);
            criatura.ataque.atacar(jogador.vida);
            escrever(criatura.nome + " contra-atacou e causou "
                    + criatura.ataque.dano + " de dano!");

            System.out.println();
            turno++;
        }

        System.out.println();
        if (jogador.vida.estaViva()) {
            escrever("Você venceu " + criatura.nome + "!");
        } else {
            escrever("Você foi derrotado...");
        }
    }

    public static void main(String[] args) {

        Charada charada = new Charada();
        Jogador jogador = new Jogador();

        escrever("=== RPGZINHO ===");
        escrever("Você entra numa caverna escura...");
        escrever("Uma voz ecoa e propõe uma charada.");
        continuar();

        int indice = charada.sortearIndice();

        System.out.println("CHARADA:");
        esperar(600);
        escrever(charada.getCharada(indice));

        System.out.print("Resposta: ");
        String resposta = entrada.nextLine();
        System.out.println();

        escrever("A voz fica em silêncio por um instante...");
        esperar(700);

        if (charada.verificarResposta(indice, resposta)) {
            escrever("Você acertou!");
            escrever("Uma luz brilha no fundo da caverna...");

            Tesouro tesouro = new Tesouro();
            jogador.items.add(tesouro);

            System.out.print("Você ganhou: ");
            esperar(800);
            tesouro.mostrarNome();
        } else {
            escrever("Você errou!");
            escrever("Resposta correta: " + charada.getResposta(indice));
            esperar(500);
            escrever("Passos pesados se aproximam...");

            Criatura criatura = new Criatura();
            escrever("Uma criatura apareceu!");
            criatura.exibir();
            continuar();

            batalha(jogador, criatura);
        }

        entrada.close();
    }
}