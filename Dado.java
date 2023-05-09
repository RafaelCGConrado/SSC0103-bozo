public class Dado{
    private int lados;
    private int lado_anterior;
    private static Random random = new Random();

    Dado(){
        lados = 6;
        lado_anterior = -1;

    }

    Dado(int n){
        lados = n;
        lado_anterior = -1;
    }

    int getLado(){
       return this.lado_anterior;

    }

    int rolar(){
        
        int rolagem = random.getIntRand(lados);
        rolagem++;
        
        this.lado_anterior = rolagem;
        return rolagem;
    }


    public static void main(String[] args){
        Dado dado = new Dado();
        // System.out.println(dado.lado_anterior);
        System.out.println(dado.rolar());
        System.out.println(dado.lado_anterior);

        System.out.println(dado.rolar());
        System.out.println(dado.lado_anterior);

        System.out.println(dado.rolar());
        System.out.println(dado.lado_anterior);
    }


}