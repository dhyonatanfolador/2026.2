import java.util.Random;

public class Criatura {
    String nome;
    Vida vida;
    Armas ataque;

    public Criatura() {
        Random aleatorio = new Random();
        int a = aleatorio.nextInt(4);
        int b = aleatorio.nextInt(3);
        String[] tico = {"Goblin ", "Trasgo ", "Troll ", "Kobold "};
        String[] teco = {"da Montanha", "da Caverna", "da Floresta"};
        int[] vidas = {20, 50, 100, 10};
        int[] danos = {6, 12, 20, 4};

        nome = tico[a] + teco[b];
        vida = new Vida(vidas[a]);
        ataque = new Armas(danos[a]);
    }

    public void exibir() {
        System.out.println(nome);
        System.out.println("Vida: " + vida.pontos);
        System.out.println("Dano: " + ataque.dano);
    }
}