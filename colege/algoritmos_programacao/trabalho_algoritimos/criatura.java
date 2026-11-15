import java.util.Random;

class criatura {
    String nome;
    int Vida;
    int dano;

    public criatura()
    {
        Random aleatorio = new Random();
        int a = aleatorio.nextInt(4);
        int b = aleatorio.nextInt(3);
        String tico[] = {"Goblin ","Trasgo ","Troll ","Kobold "};
        String teco[] = {"da Montanha","da Caverna","da Floresta"};
        int vidas[] = {20,50,100,10};
        int ataques[] = {6,12,20,4};
        
        this.nome = tico[a] + teco[b];
        this.Vida = vidas[a];
        this.dano = ataques[a];
    }

    public criatura(int a,int b){
        this.nome = "Ciclope Das Charadas";
        this.Vida = a;
        this.dano = b;
    }

    int atacar()
    {
        return this.dano;
    }

    void tomarDano(int a)
    {
        this.Vida = -a + this.Vida;
    }
}