/*
 * Desenvolvido por Rafael Conrado
 */

public class Bozo {

    public static void main(java.lang.String[] args) throws java.io.IOException{
        RolaDados rD = new RolaDados(5);
        Placar placar = new Placar();

        //Aguarda o usuário apertar ENTER para iniciar a rodada
        for(int i = 0; i < 10; i++){
            System.out.println("Pressione ENTER para iniciar a rodada:");
            String input = EntradaTeclado.leString();
            System.out.println(input);
            
            
            while(!input.equals("")){
                System.out.println("Pressione ENTER para iniciar a rodada:");
                input = EntradaTeclado.leString();
            }

            //Rola todos os dados, exibe a rodada atual e a representação dos dados
            rD.rolar();
            System.out.println("Rodada " + (i+1) + ":");
            System.out.println(rD.toString());


            int[] dados = new int[5];
            
            //O usuário escolhe quais dados serão rolados novamente (duas vezes)
            for(int j = 0; j < 2; j++){
                System.out.println("Digite quais dados você deseja rolar novamente: ");
                String dadosNovos = EntradaTeclado.leString();
                dados = rD.rolar(dadosNovos);
                System.out.println(rD.toString());

            }

            //Imprime o placar atual e o usuário pode escolher a posição que será
            //ocupada
            System.out.println("Placar atual: " + placar.getScore());
            System.out.println("Escolha a posição: ");
            System.out.println(placar.toString());

            //Efetua o cálculo da pontuação e salva no placar.
            //O tabuleiro também é exibido novamente
            int posicao = EntradaTeclado.leInt();
            placar.add(posicao, dados);
            System.out.println("Placar atual: " + placar.getScore());
            System.out.println(placar.toString());

        }

        //Encerra o jogo
        System.out.println("------------------------");
        System.out.println("Fim de jogo.");
        System.out.println("O placar final foi de " + placar.getScore() + " pontos!");
        System.out.println("------------------------");
    }       

}
