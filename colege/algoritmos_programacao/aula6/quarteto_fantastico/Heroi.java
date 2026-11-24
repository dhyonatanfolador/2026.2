package colege.algoritmos_programacao.aula6.quarteto_fantastico;

abstract class Heroi {
    private String nome;
    private String nomeHeroi;
    private int energia;

    public Heroi(String nome, String nomeHeroi) {
        this.nome = nome;
        this.nomeHeroi = nomeHeroi;
        this.energia = 100;
        System.out.println("Nasceu um novo heroi!");
    }

    public String getNome() {
        return nome;
    }

    public String getNomeheroi() {
        return nomeHeroi;
    }

    public int getEnergia() {
        return energia;
    }
}
