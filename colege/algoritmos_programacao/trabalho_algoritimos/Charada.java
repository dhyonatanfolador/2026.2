import java.util.Random;

class Charada {

    String[] charadasFacil = {
        "Quanto mais tira, maior fica?",
        "Tem dentes, mas não morde?",
        "Tem cidades, mas não tem casas?",
        "Corre, mas não tem pernas?",
        "Quanto mais seca, mais molhada fica?",
    };

    String[] respostasFacil = {
        "Buraco",
        "Pente",
        "Mapa",
        "Rio",
        "Toalha"
    };

    String[] charadasMedio = {
        "Tem um olho só, mas não enxerga?",
        "É seu, mas os outros usam mais do que você?",
        "Nasce grande e morre pequeno?",
        "Tem pescoço, mas não tem cabeça?",
        "Tem mãos e rosto, mas não tem corpo?",
        "Sobe quando a chuva desce?"
    };

    String[] respostasMedio = {
        "Agulha",
        "Nome",
        "Lapis",
        "Garrafa",
        "Relogio",
        "Guarda-chuva"
    };

    String[] charadasDificil = {
        "Quebra assim que você fala o nome dele?",
        "Você pode dar a alguém e ainda assim continuar com ela?",
        "Fala todas as línguas sem nunca ter aprendido nenhuma?",
        "Nunca chega, mas está sempre por vir?",
        "Está sempre à sua frente, mas ninguém consegue ver?",
        "Quanto mais tem, menos você enxerga?"
    };

    String[] respostasDificil = {
        "Silencio",
        "Palavra",
        "Eco",
        "Amanha",
        "Futuro",
        "Escuridao"
    };


    String[] charadas;
    String[] respostas;

    Random aleatorio = new Random();

    public Charada(int difi) {
        definirDificuldade(difi);
    }

    public void definirDificuldade(int difi) {
        if (difi == 1) {
            charadas = charadasFacil;
            respostas = respostasFacil;
        } else if (difi == 2) {
            charadas = charadasMedio;
            respostas = respostasMedio;
        } else if (difi == 3) {
            charadas = charadasDificil;
            respostas = respostasDificil;
        } 
    }

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
