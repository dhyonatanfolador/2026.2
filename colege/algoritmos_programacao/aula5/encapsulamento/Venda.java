package colege.algoritmos_programacao.aula5.encapsulamento;

public class Venda {

    private String cliente;
    private Produto vendido;

    public Venda() {
        this.vendido = new Produto();
    }

    public boolean efetuarVenda(String nome, String cliente) {
        if (nome == null || cliente == null) {
            return false;
        }

        this.cliente = cliente;
        vendido.setNome(nome);

        return true;
    }

    public String getCliente() {
        return cliente;
    }

    public Produto getVendido() {
        return vendido;
    }
}