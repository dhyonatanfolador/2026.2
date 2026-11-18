package colege.algoritmos_programacao.aula5.trabalho_algoritimos;
import java.util.ArrayList;

class jogador 
{
    int dano;
    int vida = 100;

    

    ArrayList<itens> inventario = new ArrayList<>();

    public jogador() 
    {
        armas armaInicial = new armas();
        inventario.add(armaInicial);
        this.dano = armaInicial.dano;
    }

    void mostrarInventario() 
    {
        for (int i = 0; i < inventario.size(); i++) 
        {
            System.out.printf("(%d) %s\n", i, inventario.get(i).nome);
        }
    }

    void guardaraIten(itens item) 
    {
        inventario.add(item);
    }

    void equipar(int a) 
    {
        if (a < 0 || a >= inventario.size()) 
        {
            System.out.println("Posicao invalida no inventario\n");
            return;
        }

        itens item = inventario.get(a);

        if (item instanceof armas) 
        {
            armas arma = (armas) item;

            this.dano = arma.dano;

            System.out.printf("\nVoce equipou %s e o dano agora eh: %d\n",arma.nome, arma.dano);
        }

        else if (item instanceof Pocao) 
        {
            Pocao pocao = (Pocao) item;

            if (this.vida + pocao.cura <= 100) 
            {
                this.vida += pocao.cura;
            } 
            else 
            {
                this.vida = 100;
            }

            inventario.remove(a);

            System.out.printf("Voce usou uma pocao. Vida atual: %d\n",this.vida);
        }

        else 
        {
            System.out.println("Voce nao pode equipar isso\n");
        }
    }

    void receberDano(int a)
    {
        if(-a + this.vida < 0)
            this.vida = 0;
        
        else
            this.vida = -a + this.vida;
    }

    int ataque()
    {
        return this.dano;
    }
}