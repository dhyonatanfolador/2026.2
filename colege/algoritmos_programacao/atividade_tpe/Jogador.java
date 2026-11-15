import java.util.ArrayList;

public class Jogador {
    Vida vida;
    ArrayList<Tesouro> items;
    Armas ataque;

    public Jogador() {
        vida = new Vida(100);
        items = new ArrayList<>();
        ataque = new Armas(10);
    }
}