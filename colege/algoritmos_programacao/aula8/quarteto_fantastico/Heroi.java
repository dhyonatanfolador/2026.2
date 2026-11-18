
package colege.algoritmos_programacao.aula8.quarteto_fantastico;

abstract class Heroi {

    private String nome;
    private String nomeHeroi;
    private int energia;

    public Heroi(String nome, String nomeHeroi) {
        this.nome = nome;
        this.nomeHeroi = nomeHeroi;
        this.energia = 100;

        System.out.println("Nasceu o herói...");
    }

    public String getNome() {
        return nome;
    }

    public String getNomeHeroi() {
        return nomeHeroi;
    }

    public int getEnergia() {
        return energia;
    }

    public void gastarEnergia(int qtde) {

        if (qtde <= 0 || qtde > this.energia) {
            System.out.println("Energia fora do range!");
            return;
        }

        this.energia -= qtde;
    }

    public void recuperarEnergia(int qtde) {

        if (qtde <= 0) {
            System.out.println("Recuperação de energia inválida!");
            return;
        }

        this.energia = (this.energia + qtde > 100)
                ? 100
                : this.energia + qtde;
    }

    abstract void usarPoder();
}
