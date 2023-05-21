/*
 * Desenvolvido por Rafael Conrado
 */
import java.util.Arrays;

public class Placar {  
    private int[] placar;   

    Placar(){

        //Todas as posições do array do placar são inicializadas com -1 (não ocupada)
        placar = new int[10];
        for(int i = 0; i < 10; i++){
            placar[i] = -1;
        }

    }

    /*
     * Implementa a lógica da pontuação de acordo com a posição escolhida
     * e armazena o resultado no tabuleiro
     */
    public void add(int posicao, int[] dados) throws java.lang.IllegalArgumentException{
        
        int posicaoReal = posicao - 1; //O array do placar vai de 0 a 9.
        int contadorFrequencia = 0; //Contador de frequência do lado nos dados rolados

        //Verifica se a posição não está vazia
        if(placar[posicaoReal] != -1) throw new IllegalArgumentException("Posição já ocupada.");

        //Para as posições externas do placar:
        if(posicaoReal <= 6){
            
            //Conta a frequência dos lados correspondentes à posição escolhida
            //e calcula a posição a partir disso
            for(int i = 0; i < dados.length; i++){
                if(dados[i] == posicao){
                    contadorFrequencia++;
                }
            }

            placar[posicaoReal] = (contadorFrequencia * posicao);

        }

        //Posições internas do placar:

        if(posicao == 7){
            //FullHand: três dados de um tipo e dois de outro (ou do mesmo)
            
            //Verifica se é um FullHand e salva a pontuação correspondente
            if(isFullHand(dados)) placar[posicaoReal] = 15;
            else placar[posicaoReal] = 0;
            
        }

        if(posicao == 8){
            //Sequencia :Lados de 1 a 5 ou de 2 a 6
            if(isSequencia(dados)) placar[posicaoReal] = 20;
            else placar[posicaoReal] = 0;
        }

        if(posicao == 9){
            //Quadra: Quatro lados iguais
            if(isQuadra(dados)) placar[posicaoReal] = 30;
            else placar[posicaoReal] = 0;

            
        }

        if(posicao == 10){
            //Quina: Cinco lados iguais
            if(isQuina(dados)) placar[posicaoReal] = 40;
            else placar[posicaoReal] = 0;
        }





    }

    /*
     * Calcula a pontuação total do jogo no momento específico
     */
    public int getScore(){
        int score = 0;
        
        //Percorre o array do placar e soma as pontuações de cada posição,
        //caso a posição específica esteja preenchida (diferente de -1)
        for(int i = 0; i < 10; i++){
            if(placar[i] != -1){
                score = score + placar[i];
            }
        }

        return score;
    }

    /*
     * Método privado para verificar se a sequência dos dados obtidos é uma FullHand
     */
    private boolean isFullHand(int[] dados){
        int frequencia1 = 1, frequencia2 = 0;
        int lado1, lado2 = -1;
        lado1 = dados[0];

        for(int i = 1; i < dados.length; i++){
            
            //Se o lado atual é igual ao primeiro lado do array de dados
            if(dados[i] == lado1) frequencia1++;

            else{
                //Se o segundo lado da sequência ainda não tiver sido registrado
                if(lado2 == -1){
                    lado2 = dados[i];
                    frequencia2++;
                }

                //Caso o segundo lado já tenha sido
                //registrado e seja igual ao lado atual,
                // apenas aumenta a frequência do segundo tipo
                else if(lado2 == dados[i]){
                    frequencia2++;
                }
            }
        }

        if(frequencia1 == 3 && frequencia2 == 2 || frequencia1 == 5
           || frequencia1 == 2 && frequencia2 == 3){
            return true;
        }

        return false;
    }

    /*
     * Método privado para determinar se a sequência de dados forma uma combinação
     * do tipo Sequencia
     */
    private boolean isSequencia(int[] dados){

        //Ordena os dados e verifica se o lado anterior é 1 unidade menor
        //do que o atual, para cada lado da sequência de dados
        Arrays.sort(dados);
        for(int i = 1; i < dados.length ; i++){
            if(dados[i-1] != dados[i] - 1) return false;
        }

        return true;
    }

    /*
     * Método privado para determinar se a sequência de dados forma uma Quadra
     */
    private boolean isQuadra(int[] dados){
        int frequencia1 = 1, frequencia2 = 0;
        int lado1, lado2 = -1;
        lado1 = dados[0];


        for(int i = 1; i < dados.length; i++){
            
            //Se o lado atual for igual ao lado já registrado
            if(dados[i] == lado1) frequencia1++;

            else{
                //Se o segundo lado da sequência ainda não tiver sido registrado
                if(lado2 == -1){
                    lado2 = dados[i];
                    frequencia2++;
                }

                //Caso contrário, só aumenta a frequencia do tipo 2 de lado
                else if(lado2 == dados[i])frequencia2++;
            }

        }

        if(frequencia1 == 4 || frequencia2 == 4) return true;
        return false;
    }


    /*
     * Método privado para determinar se a sequência de lados forma
     * uma Quina
     */
    private boolean isQuina(int[] dados){
        int lado = dados[0];
        int frequencia = 1;

        for(int i = 1; i < dados.length; i++){
            if(dados[i] == lado) frequencia++;

        }

        if(frequencia == 5) return true;
        return false;
        
    }

    /*
     * Representa o placar do jogo em cada rodada
     */
    @Override
    public java.lang.String toString(){
        
        String resultado = new String();

        resultado = 
                    "+-----------------------------------------------+\n" +
                    "|\t" + (placar[0] == -1 ? "(1)" : placar[0]) + "\t|" +
                    "\t"+ (placar[6] == -1 ? "(7)" : placar[6]) + "\t|"+
                    "\t" + (placar[3] == -1 ? "(4)" : placar[3]) + "\t|\n" +
                    "-------------------------------------------------\n"+

                    "|\t" + (placar[1] == -1 ? "(2)" : placar[1]) + "\t|" +
                    "\t"+ (placar[7] == -1 ? "(8)" : placar[7]) + "\t|"+
                    "\t" + (placar[4] == -1 ? "(5)" : placar[4]) + "\t|\n" +
                    "-------------------------------------------------\n"+

                    "|\t" + (placar[2] == -1 ? "(3)" : placar[2]) + "\t|" +
                    "\t"+ (placar[8] == -1 ? "(9)" : placar[8]) + "\t|"+
                    "\t" + (placar[5] == -1 ? "(6)" : placar[5]) + "\t|\n" +
                    "-------------------------------------------------\n" +

                    "\t\t|\t" + (placar[9] == -1 ? "(10)" : placar[9]) + "\t|\t\t\n"+

                    "\t\t+---------------+\n";
        
        
        return resultado;


    }



    /*
     * Utilizada para testes
     */
    public static void main(String[] args){

        Placar p = new Placar();

        int[] dados = {6,2,4,5,3};
        if(p.isSequencia(dados)) System.out.println("É sequencia");

    }

    


}
