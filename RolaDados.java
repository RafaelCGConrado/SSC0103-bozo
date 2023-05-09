public class RolaDados {
    Dado[] dados;
    public int n_dados;



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
        int tamanho_s = s.length();

        for(int i = 0; i < tamanho_s; i++){
            String[] palavra = new String[1];
            palavra = 


        }
        
    }


    public static void main(String[] args){
        int n = 5;
        RolaDados r = new RolaDados(n);

        int[] rolados;
        rolados = new int[n];

        boolean[] quais = {true, true, true, true, true};

        rolados = r.rolar(quais);
        for(int i = 0; i < n; i++){
            System.out.println(rolados[i]);
        }





    }
}
