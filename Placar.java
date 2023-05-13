public class Placar {  
    private int[] placar;   

    Placar(){
        for(int i = 0; i < 10; i++){
            placar[i] = -1;
        }



    }

    public void add(int posicao, int[] dados) throws java.lang.IllegalArgumentException{
        int soma = 0;
        for(int i = 0; i < 5; i++){
            soma = soma + dados[i];
        }

        placar[posicao - 1] = soma;


    }

    public int getScore(){
        int score = 0;
        
        for(int i = 0; i < 10; i++){
            if(placar[i] != -1){
                score = score + placar[i];
            }
        }

        return score;
    }

    // @Override
    // public java.lang.String toString(){

        
    // }




    public static void main(String[] args){
        


    }

    


}
