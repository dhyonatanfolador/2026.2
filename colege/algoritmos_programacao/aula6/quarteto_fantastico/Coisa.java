package colege.algoritmos_programacao.aula6.quarteto_fantastico;

final class Coisa extends Heroi {

    private String poderEspecial;

    public Coisa (String nome, String nomeHeroi) {
        super(nome, nomeHeroi);
        System.out.println("O coisa!");
    }

    public String getPoderEspecial () {
        return this.poderEspecial;
    }

    public void setPoderEspecial (String novoPoder) {
        this.poderEspecial = novoPoder;
    }
}
