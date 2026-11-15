
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        jogador Jogador = new jogador();
        Bau bau = new Bau();

        System.out.println("=== AVENTURA DAS CHARADAS ===");
        System.out.println("Escolha a dificuldade:");
        System.out.println("1 - Facil");
        System.out.println("2 - Medio");
        System.out.println("3 - Dificil");
        System.out.print("Escolha: ");

        int nivel = input.nextInt();
        input.nextLine();                          

        Charada charada = new Charada(nivel);

        int i = 0;

        System.out.println("\nVida: " + Jogador.vida);
        System.out.println("Dano inicial: " + Jogador.ataque());

        while (Jogador.vida > 0 && i < 6) {
        // ... daqui pra baixo continua exatamente como estava
            int indice = charada.sortearIndice();

            System.out.println("\n===== CHARADA " + (i + 1) + " =====");
            System.out.println(charada.getCharada(indice));
            System.out.print("Resposta: ");

            String resposta = input.nextLine();

            if (charada.verificarResposta(indice, resposta)) 
            {
                System.out.println("\nVoce acertou!");
                itens recompensa = bau.abrirBau();

                System.out.println("Voce encontrou: " + recompensa.nome);
                Jogador.guardaraIten(recompensa);
            } 

            else 
            {
                System.out.println("\nVoce errou!");
                System.out.println("Resposta correta: " + charada.getResposta(indice));
                System.out.println("Voce precisa lutar!");

                criatura inimigo = new criatura();
                combate(Jogador, inimigo, input);
            }

            if (Jogador.vida <= 0) 
            {
                break;
            }

            i++;

            if (i < 6) 
            {
                pausaInventario(Jogador, input);
            }
        }

        if (Jogador.vida <= 0) 
        {
            System.out.println("\nVOCE MORREU!");
        } 
        else 
        {
            System.out.println("\nPARABENS! Voce completou as charadas!");
        }

        System.out.println("\n=== ESTADO FINAL ===");
        System.out.println("Vida: " + Jogador.vida);
        System.out.println("Dano: " + Jogador.ataque());
        Jogador.mostrarInventario();

        input.close();
    }

    static void combate(jogador Jogador,criatura inimigo,Scanner input) 
    {
        System.out.println("\n=== COMBATE ===");
        System.out.println("Inimigo: " + inimigo.nome);
        System.out.println("Vida do inimigo: " + inimigo.Vida);
        System.out.println("Dano do inimigo: " + inimigo.dano);

        while (Jogador.vida > 0 && inimigo.Vida > 0) 
        {
            System.out.println("\nSua vida: " + Jogador.vida);
            System.out.println("Vida do inimigo: " + inimigo.Vida);

            System.out.println("\n1 - Atacar");
            System.out.println("2 - Inventario");
            System.out.println("3 - Fugir");
            System.out.print("Escolha: ");

            int escolha = input.nextInt();
            input.nextLine();

            if (escolha == 1) 
            {
                int dano = Jogador.ataque();

                inimigo.tomarDano(dano);

                System.out.println("\nVoce causou " + dano + " de dano!");

                if (inimigo.Vida <= 0) 
                {
                    System.out.println("Voce derrotou " + inimigo.nome + "!");
                    break;
                }

            } 

            else if (escolha==2) 
            {
                pausaInventario(Jogador, input);
            }

            else if (escolha == 3) 
            {
                System.out.println("Voce fugiu do combate!");
                return;
            } 

            else 
            {
                System.out.println("Opcao invalida!");
                continue;
            }

            
            if (inimigo.Vida > 0) 
            {
                int danoInimigo = inimigo.atacar();
                Jogador.receberDano(danoInimigo);

                System.out.println(inimigo.nome + " causou " + danoInimigo + " de dano!");
            }
        }
    }

    static void pausaInventario(jogador Jogador, Scanner input) {
        while (true) 
        {
            System.out.println("\n=== PAUSA ===");
            System.out.println("Vida: " + Jogador.vida);
            System.out.println("Dano: " + Jogador.ataque());

            System.out.println("\n1 - Mostrar inventario");
            System.out.println("2 - Equipar arma / usar pocao");
            System.out.println("3 - Continuar aventura");
            System.out.print("Escolha: ");

            int escolha = input.nextInt();
            input.nextLine();

            if (escolha == 1) 
            {
                Jogador.mostrarInventario();
            } 

            else if (escolha == 2) 
            {
                Jogador.mostrarInventario();

                System.out.print("Digite o indice do item (ou -1 para cancelar): ");

                int entrada = input.nextInt();
                input.nextLine();

           
                if (entrada != -1 && entrada < Jogador.inventario.size()) 
                {
                    Jogador.equipar(entrada);
                }

                else
                {
                    System.out.println("Digite um numero valido!");
                }

            } 

            else if (escolha == 3) 
            {
                System.out.println("Voce continuou a aventura!");
                return;
            } 

            else 
            {
                System.out.println("Opcao invalida!");
            }
        }
    }
}
