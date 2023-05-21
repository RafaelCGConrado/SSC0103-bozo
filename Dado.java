/*
 * Desenvolvido por Rafael Conrado
 */

public class Dado{
    private int lados;
    private int lado_anterior;
    private static Random random = new Random();

    Dado(){
        lados = 6;
        lado_anterior = -1; //O lado anterior é sempre inicializado com -1 (não rolado)

    }

    Dado(int n){
        lados = n;
        lado_anterior = -1; //O lado anterior é sempre inicializado com -1 (não rolado)
    }

    /*
     * Retorna o último lado obtido na rolagem
     */
    int getLado(){
       return this.lado_anterior;

    }


    /*
     * Rola o dado e armazena o lado obtido em lado_anterior
     */
    int rolar(){
        int rolagem = random.getIntRand(lados);
        rolagem++; //Aumenta 1 no resultado aleatório para ficar entre 1 e 5
        
        lado_anterior = rolagem;
        return rolagem;
    }

    /*
     * Representa em formato de string o lado do dado obtido na rolagem
     */
    @Override
    public java.lang.String toString(){
        String extremidade = "+-----+";
        String linha1 = new String();
        String linha2 = new String();
        String linha3 = new String();
        
        switch(lado_anterior){
            case 1:
                linha1 = "|     |";
                linha2 = "|  *  |";
                linha3 = "|     |";
                break;

            case 2:
                linha1 = "|*    |";
                linha2 = "|     |";
                linha3 = "|    *|";
                break;

            case 3:
                linha1 = "|*    |";
                linha2 = "|  *  |";
                linha3 = "|    *|";
                break;

            case 4:
                linha1 = "|*   *|";
                linha2 = "|     |";
                linha3 = "|*   *|";
                break;

            case 5:
                linha1 = "|*   *|";
                linha2 = "|  *  |";
                linha3 = "|*   *|";
                break;

            case 6: 
                linha1 = "|*   *|";
                linha2 = "|*   *|";
                linha3 = "|*   *|";
                break;
            
            case -1:
                linha1 = "       ";
                linha2 = "       ";
                linha3 = "       ";
            
            // String resultado = extremidade + linha1+ linha2+ linha3+ extremidade;
        }
        
        String resultado = (extremidade+"\n"+linha1+"\n"+linha2+"\n"+linha3+"\n"+extremidade);
        return resultado;
        }
    
    /*
     * Usada apenas para testes
     */
    public static void main(String[] args){
        Dado dado = new Dado();
        // System.out.println(dado.lado_anterior);
        System.out.println(dado.rolar());
        String resultado = dado.toString();

        System.out.print(resultado);
    }


}