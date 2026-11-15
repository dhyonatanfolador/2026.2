import java.util.Random;

public class Tesouro {
    String nome;

    public Tesouro() {
        Random aleatorio = new Random();
        String[] tipo = {" ouro", " prata", " cobre"};
        String[] teso = {"moedas de", "anel de", "medalhao de"};

        nome = teso[aleatorio.nextInt(teso.length)]
             + tipo[aleatorio.nextInt(tipo.length)];
    }

    public void mostrarNome() {
        System.out.println(nome);
    }
}