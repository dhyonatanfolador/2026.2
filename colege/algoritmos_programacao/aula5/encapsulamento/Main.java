package colege.algoritmos_programacao.aula5.encapsulamento;

public class Main {

    public static void main(String[] args) {

        Produto produto = new Produto();

        produto.setNome("Detergente");
        produto.setCusto(14.99);
        produto.setLucro(50);

        Venda venda = new Venda();

        boolean sucesso = venda.efetuarVenda(
            produto.getNome(),
            "João"
        );

        if (sucesso) {
            System.out.println("Venda efetuada!");
            System.out.println("Cliente: " + venda.getCliente());
            System.out.println("Produto: " + produto.getNome());
            System.out.printf("Custo: R$ %.2f%n", produto.getCusto());
            System.out.printf("Lucro: R$ %.2f%n", produto.getLucro());
            System.out.printf("Preço de venda: R$ %.2f%n", produto.getVenda());
        } else {
            System.out.println("Não foi possível efetuar a venda.");
        }
    }
}