
package colege.algoritmos_programacao.aula8.quarteto_fantastico;

final class TochaHumana extends Heroi {

    public TochaHumana(String nome, String nomeHeroi) {
        super(nome, nomeHeroi);

        System.out.println("Tocha Humana!");
    }

    @Override
    void usarPoder() {

        System.out.println("Ataque: Rajada de fogo!");

        this.gastarEnergia(25);
    }
}
