public class Bozo {

    public static void main(java.lang.String[] args) throws java.io.IOException{
        RolaDados rD = new RolaDados(5);
        Placar placar = new Placar();

        for(int i = 0; i < 10; i++){
            System.out.println("Pressione ENTER para iniciar a rodada:");
            String input = EntradaTeclado.leString();
            System.out.println(input);
            
            
            while(!input.equals("")){
                System.out.println("Pressione ENTER para iniciar a rodada:");
                input = EntradaTeclado.leString();
            }

            rD.rolar();
            System.out.println("Rodada " + (i+1) + ":");
            System.out.println(rD.toString());

            int[] dados = new int[5];

            for(int j = 0; j < 2; j++){
                System.out.println("Digite quais dados você deseja rolar novamente: ");
                String dadosNovos = EntradaTeclado.leString();
                dados = rD.rolar(dadosNovos);
                System.out.println(rD.toString());

            }

            System.out.println("Placar atual: " + placar.getScore());
            System.out.println("Escolha a posição: ");
            System.out.println(placar.toString());

            int posicao = EntradaTeclado.leInt();
            placar.add(posicao, dados);
            System.out.println("Placar atual: " + placar.getScore());
            System.out.println(placar.toString());

        }

        System.out.println("O placar final foi de " + placar.getScore() + "pontos!");
    }       

        
}
