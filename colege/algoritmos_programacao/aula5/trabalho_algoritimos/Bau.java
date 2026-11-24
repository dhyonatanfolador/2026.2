package colege.algoritmos_programacao.aula5.trabalho_algoritimos;
import java.util.Random;
class Bau
{
    itens abrirBau() 
    {
        Random aleatorio = new Random();

        int sorteio = aleatorio.nextInt(3);

        switch (sorteio) 
        {
            case 0:
                return new armas();
           
            case 1:
                return new tesouro();
           

            default:
                return new Pocao();
             

        }
    }
}