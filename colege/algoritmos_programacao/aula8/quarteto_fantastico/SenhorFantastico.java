
package colege.algoritmos_programacao.aula8.quarteto_fantastico;

final class SenhorFantastico extends Heroi {

    public SenhorFantastico(String nome, String nomeHeroi) {
        super(nome, nomeHeroi);

        System.out.println("Senhor Fantástico!");
    }

    @Override
    void usarPoder() {

        System.out.println("Ataque: Elasticidade extraordinária!");

        this.gastarEnergia(15);
    }
}
