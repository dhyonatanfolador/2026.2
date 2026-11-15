public class Armas {
    int dano;

    public Armas(int dano) {
        this.dano = dano;
    }

    public void atacar(Vida alvo) {
        alvo.receberDano(dano);
    }
}