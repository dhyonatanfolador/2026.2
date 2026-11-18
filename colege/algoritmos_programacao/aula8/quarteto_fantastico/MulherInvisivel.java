
package colege.algoritmos_programacao.aula8.quarteto_fantastico;

final class MulherInvisivel extends Heroi {

    public MulherInvisivel(String nome, String nomeHeroi) {
        super(nome, nomeHeroi);

        System.out.println("Mulher Invisível!");
    }

    @Override
    void usarPoder() {

        System.out.println("Ataque: Campo de força invisível!");

        this.gastarEnergia(15);
    }
}
