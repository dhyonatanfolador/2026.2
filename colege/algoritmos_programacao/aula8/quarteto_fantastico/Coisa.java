
package colege.algoritmos_programacao.aula8.quarteto_fantastico;

final class Coisa extends Heroi {

    private String poderEspecial;

    public Coisa(String nome, String nomeHeroi) {
        super(nome, nomeHeroi);

        this.poderEspecial = "Força sobre-humana";

        System.out.println("O Coisa!");
    }

    public String getPoderEspecial() {
        return poderEspecial;
    }

    public void setPoderEspecial(String novoPoder) {
        this.poderEspecial = novoPoder;
    }

    @Override
    void usarPoder() {

        System.out.println("Ataque: Força da pedra bruta!");

        this.gastarEnergia(20);
    }
}
