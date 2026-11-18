
package colege.algoritmos_programacao.aula8.quarteto_fantastico;

public class Missao {

    private String descricao;
    private Heroi[] equipe;

    public Missao(String descricao, Heroi[] equipe) {
        this.descricao = descricao;
        this.equipe = equipe;
    }

    public String getDescricao() {
        return descricao;
    }

    public void executarMissao() {

        System.out.println("\n================================");
        System.out.println("MISSÃO: " + descricao);
        System.out.println("================================");

        for (Heroi heroi : equipe) {

            System.out.println("\nHerói: " + heroi.getNomeHeroi());

            if (heroi.getEnergia() >= 25) {
                heroi.usarPoder();
                System.out.println("Energia restante: "
                        + heroi.getEnergia());
            } else {
                System.out.println("Energia insuficiente!");
            }
        }

        System.out.println("\nMissão finalizada!");
    }
}
