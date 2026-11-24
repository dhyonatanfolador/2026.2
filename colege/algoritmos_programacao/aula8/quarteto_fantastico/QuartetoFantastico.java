
package colege.algoritmos_programacao.aula8.quarteto_fantastico;

public class QuartetoFantastico {

    public static void main(String[] args) {

        System.out.println("CADASTRO DO QUARTETO FANTÁSTICO!");

        // Criando os quatro heróis

        Coisa coisa = new Coisa("Ben Grimm", "Coisa");

        SenhorFantastico senhor = new SenhorFantastico(
                "Reed Richards",
                "Senhor Fantástico"
        );

        MulherInvisivel mulher = new MulherInvisivel(
                "Sue Storm",
                "Mulher Invisível"
        );

        TochaHumana tocha = new TochaHumana(
                "Johnny Storm",
                "Tocha Humana"
        );

        // Criando a equipe

        Heroi[] equipe = {
            coisa,
            senhor,
            mulher,
            tocha
        };

        // Exibindo os heróis

        System.out.println("\n--- EQUIPE ---");

        for (Heroi heroi : equipe) {

            System.out.println(
                    "Nome: " + heroi.getNome()
                    + " | Herói: " + heroi.getNomeHeroi()
                    + " | Energia: " + heroi.getEnergia()
            );
        }

        // Criando uma missão

        Missao missao = new Missao(
                "Salvar a cidade de Nova York",
                equipe
        );

        // Executando a missão

        missao.executarMissao();

        // Recuperando energia

        System.out.println("\n--- RECUPERAÇÃO DE ENERGIA ---");

        coisa.recuperarEnergia(20);

        System.out.println(
                "Energia do Coisa: " + coisa.getEnergia()
        );
    }
}
