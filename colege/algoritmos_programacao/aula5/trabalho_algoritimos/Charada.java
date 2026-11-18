package colege.algoritmos_programacao.aula5.trabalho_algoritimos;
import java.util.Random;
class Charada {

    String[] charadas = {
        "Quanto mais tira, maior fica?",
        "Tem dentes, mas não morde?",
        "Tem cidades, mas não tem casas?",
        "Corre, mas não tem pernas?",
        "Quanto mais seca, mais molhada fica?"
    };

    String[] respostas = {
        "Buraco",
        "Pente",
        "Mapa",
        "Rio",
        "Toalha"
    };

    Random aleatorio = new Random();

    public int sortearIndice() {
        return aleatorio.nextInt(charadas.length);
    }

    public String getCharada(int indice) {
        return charadas[indice];
    }

    public boolean verificarResposta(int indice, String resposta) {
        return respostas[indice].equalsIgnoreCase(resposta);
    }

    public String getResposta(int indice) {
        return respostas[indice];
    }
}