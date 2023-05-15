import java.util.Arrays;

public class Placar {  
    private int[] placar;   

    Placar(){
        placar = new int[10];
        for(int i = 0; i < 10; i++){
            placar[i] = -1;
        }

    }

    public void add(int posicao, int[] dados) throws java.lang.IllegalArgumentException{
        
        int posicaoReal = posicao - 1;
        int contadorFrequencia = 0;

        //Posicões externas do placar
        if(posicaoReal <= 6){
            
            for(int i = 0; i < dados.length; i++){
                if(dados[i] == posicao){
                    contadorFrequencia++;
                }
            }

            placar[posicaoReal] = (contadorFrequencia * posicao);

        }

        //Posições internas do placar
        if(posicao == 7 && isFullHand(dados)){
            //full hand -> tres dados de um e dois de outro (ou do mesmo))
            //10 pontos
            placar[posicaoReal] = 15;

            
        }

        if(posicao == 8 && isSequencia(dados)){
            //sequencia : numeros de 1 a 5 ou de 2 a 6
            placar[posicaoReal] = 20;
        }

        if(posicao == 9 && isQuadra(dados)){



            placar[posicaoReal] = 30;
        }

        if(posicao == 10 && isQuina(dados)){



            placar[posicaoReal] = 40;
        }





    }

    public int getScore(){
        int score = 0;
        
        //Percorre o vetor de placar e soma as pontuações
        //caso a posição específica esteja preenchida
        for(int i = 0; i < 10; i++){
            if(placar[i] != -1){
                score = score + placar[i];
            }
        }

        return score;
    }

    private boolean isFullHand(int[] dados){
        int frequencia1 = 1, frequencia2 = 0;
        int lado1, lado2 = -1;
        lado1 = dados[0];

        for(int i = 1; i < dados.length; i++){
            if(dados[i] == lado1) frequencia1++;

            else{
                if(lado2 == -1){
                    lado2 = dados[i];
                    frequencia2++;
                }

                else if(lado2 == dados[i]){
                    frequencia2++;
                }
            }
        }

        if(frequencia1 == 3 && frequencia2 == 2 || frequencia1 == 5){
            return true;
        }

        return false;
    }

    private boolean isSequencia(int[] dados){

        Arrays.sort(dados);
        for(int i = 1; i < dados.length ; i++){
            if(dados[i-1] != dados[i] - 1) return false;
        }

        return true;
    }

    private boolean isQuadra(int[] dados){
        int lado = dados[0];
        int frequencia = 1;

        for(int i = 1; i < dados.length; i++){
            if(dados[i] == lado) frequencia++;

        }

        if(frequencia == 4) return true;
        return false;
    }



    private boolean isQuina(int[] dados){
        int lado = dados[0];
        int frequencia = 1;

        for(int i = 1; i < dados.length; i++){
            if(dados[i] == lado) frequencia++;

        }

        if(frequencia == 5) return true;
        return false;
        
    }

    @Override
    public java.lang.String toString(){
        String linha = " ----------------------";
        String encerra = "     +--------+  ";
        String resultado = new String();

        for(int i = 0; i < 3; i++){
            resultado = resultado + placar[i] + "    |   " + placar[i+6] + "    |   " + placar[i + 3] + "\n"; 
            resultado = resultado + linha + "\n";
            
        }

        resultado = resultado + "     |   " + placar[9] + "    |" + "\n" + encerra;

    

        return resultado;


    }




    public static void main(String[] args){

        Placar p = new Placar();
        // int []pontos = {1,1,1,1,1};

        // for(int i = 0; i < 10; i++){
        //     p.add(i + 1, pontos);
        // }


        // System.out.println(p.toString());
        int[] dados = {6,2,4,5,3};
        if(p.isSequencia(dados)) System.out.println("oi");

    }

    


}
