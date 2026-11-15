import java.util.Random;
class armas extends itens
{
    int dano;
    

    public armas()
    {
        Random aleatorio = new Random();
        int a = aleatorio.nextInt(4);
        int b = aleatorio.nextInt(3);
        String tico[] = {"espada ","lança ","materlo ","adaga "};
        String teco[] = {"de ferro","de bronze","de diamante"};
        int forca[] = {10,24,30};

        this.nome = tico[a] + teco[b];
        this.dano = forca[b];
    }

}