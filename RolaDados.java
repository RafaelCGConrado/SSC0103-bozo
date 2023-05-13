public class RolaDados {
    private Dado[] dados;
    private int n_dados;



    public RolaDados(int n){
        this.n_dados = n;
        this.dados = new Dado[n];

        for(int i = 0; i < n; i++){
            dados[i] = new Dado();
        }

    }

    public int[] rolar(){
        int[] dados_rolados = new int[this.n_dados];
        Dado d = new Dado();

        for(int i = 0; i < this.n_dados; i++){
            dados_rolados[i] = d.rolar();
            
        }

        return dados_rolados;

    }

    public int[] rolar(boolean[] quais){
        int[] dados_rolados = new int[this.n_dados];
        
        for(int i = 0; i < this.n_dados; i++){
            if(quais[i] == true){
                dados_rolados[i] = this.dados[i].rolar();
            }
            
            else{
                dados_rolados[i] = this.dados[i].getLado();
            }
        }
        return dados_rolados;

    }

    public int[] rolar(java.lang.String s){
        int[] dados_rolados = new int[this.n_dados];

        String[] palavra = s.split(" ");
        int tamanho = palavra.length;

        for(int i = 0; i < tamanho; i++){
            int numeroConvertido = Integer.parseInt(palavra[i]);
            this.dados[numeroConvertido-1].rolar();
        }

        for(int j = 0; j < this.n_dados; j++){
            dados_rolados[j] = this.dados[j].getLado();
        }
        
        return dados_rolados;
    }

    @Override
    public java.lang.String toString(){

        
        String[][] matriz = new String[n_dados][5];


        //Preenchendo a matriz
        for(int i = 0; i < n_dados; i++){
            matriz[i] = (dados[i].toString()).split("\n");

        }
        
        String resultado = new String();

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < n_dados; j++){
                resultado = resultado + matriz[j][i] + "  ";
            }
            resultado = resultado + "\n";
        }


        return resultado;
    }
    

    public static void main(String[] args){
        // int n = 3;
        // RolaDados r = new RolaDados(n);

        // int[] rolados;
        // rolados = new int[n];

        
        // rolados = r.rolar("1 2 3");
        
        // System.out.println(r.toString());


    }
}
