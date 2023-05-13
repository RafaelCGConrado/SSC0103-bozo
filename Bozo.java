public class Bozo {
    
    Bozo(){

    }





    public static void main(java.lang.String[] args) throws java.io.IOException{
        RolaDados roladados = new RolaDados(5);
        Placar placar = new Placar();

        for(int i = 0; i < 10; i++){

            System.out.println(placar.toString());

            //While !enter
            System.out.println("Rodada " + (i+1) + ":");
            System.out.println("Pressione ENTER para iniciar a rodada:");

            roladados.rolar();
            System.out.println(roladados.toString());

            System.out.println("Digite o número dos dados que quer trocar (separado por espaços): ");
            String da = "1 2 3 4";

            roladados.rolar(da);
            System.out.println(roladados.toString());






            System.out.println(placar.toString());


        }
        System.out.println("Total de pontos: " + placar.getScore());




        }
}
