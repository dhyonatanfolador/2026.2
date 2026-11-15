import java.util.Random;
class tesouro extends itens
{
    
    public tesouro()
    {
        Random aleatorio = new Random();
		String tipo[] = {" ouro"," prata"," cobre"};
		String teso[] = {"moedas de","anel de","medalhao de"};

		this.nome = teso[aleatorio.nextInt(3)] + tipo[aleatorio.nextInt(3)]; 
    }
}