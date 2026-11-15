public class Vida {
    int pontos;

    public Vida(int pontos) {
        this.pontos = pontos;
    }

    public void receberDano(int dano) {
        pontos -= dano;
        if (pontos < 0) {
            pontos = 0;
        }
    }

    public boolean estaViva() {
        return pontos > 0;
    }
}