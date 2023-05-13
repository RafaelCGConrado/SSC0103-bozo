public class Placar {  
    private int[] placar;   

    Placar(){

        //Começa preenchendo todas as posicoes
        //do placar como -1 para sinalizar
        //como não preenchidas
        

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
        else{

            /*
             * “full hand” ou seja, três dados de
                determinado número e dois de outro (ou do mesmo) e vale 15 pontos
             */
            


             /*
              * A
                segunda é uma sequência, ou seja, os dados têm todos os números de 1 a
                5 ou de 2 a 6, valendo 20 pontos

              */

              /*
               * 
               * A terceira é a posição da quadra (30
                    pontos) e a última da quina, que vale 40 pontos.
               * 
               * 
               */

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
        int []pontos = {1,1,1,1,1};

        for(int i = 0; i < 10; i++){
            p.add(i + 1, pontos);
        }


        System.out.println(p.toString());


    }

    


}
