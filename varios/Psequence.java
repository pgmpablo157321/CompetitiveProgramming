import java.util.Arrays;
import java.util.Scanner;

class Psequence{


    public static int Psequences(int n, int p){
        int l=Math.min(p, (int)(2*Math.sqrt(p)+20));
        long limites[]=new long [l];
        int aux=1, aux2=0;
        while(aux*aux<=p){
            limites[aux-1]=aux;
            aux++;
        }
        aux--;
        aux2=aux;
        
        while(aux>0){
            if(limites[aux-1]!=(p/limites[aux-1])){
                limites[aux2]=p/limites[aux-1];
                aux2++;
            }
            aux--;
        }
        
        long mat[][]=new long [n][aux2];
        for(int i=0; i<aux2; i++){
            mat[n-1][i]=1;
        }

        for(int i=n-2; i>=0;i--){
            for(int j=aux2-1; j>=0; j--){
                mat[i][j]=mat[i+1][aux2-j-1]*(limites[aux2-j-1]-((j==aux2-1)?0:limites[aux2-j-2]));
                if(j<aux2-1){
                    mat[i][j]+=mat[i][j+1];
                }
                mat[i][j]%=1000000007;
            }
        }
        long ans=0;
        for(int i=0; i<aux2; i++){
            ans+=mat[0][i]*(limites[i]-((i==0)?0:limites[i-1]));
            ans%=1000000007;
        }
        return (int)ans;
    }


    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int n=in.nextInt();
        int p=in.nextInt();
        System.out.println(Psequences(n, p));
        
        
    }
}