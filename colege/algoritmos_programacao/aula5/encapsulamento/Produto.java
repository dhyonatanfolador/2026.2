package encapsulamento;

public class Produto {
    private String nome;
    private double custo;
    private double venda;
    private double lucro;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public double getVenda() {
        return venda;
    }

    public void setVenda(double venda) {
        this.venda = venda;
    }

    public double getLucro() {
        return lucro;
    }

    public void setLucro(double percentual) {
        this.lucro = custo * (percentual / 100.0);
        this.venda = custo + lucro;
    }
}