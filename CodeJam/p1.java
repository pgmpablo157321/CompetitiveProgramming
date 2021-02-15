import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class p1{
    public static void solve(int n, int[]b, int num){
        if(b[0]==0 || b[n-1]==0){
            System.out.println("Case #"+num+": "+"IMPOSSIBLE");
        }else{
            int start=0;
            int inf[]=new int [n];
            int sup[]=new int [n];
            for(int i=0; i<n; i++){
                if(b[i]!=0){
                    inf[i]=start;
                    start+=b[i];
                    sup[i]=start-1;
                }
            }
            int max=0;
            for(int i=0; i<n; i++){
                if(b[i]!=0){
                    int aux=Math.max(Math.abs(i-inf[i]),Math.abs(i-sup[i]));
                    if(max<aux){
                        max=aux;
                    }
                }
            }
            System.out.println("Case #"+num+": "+(max+1));
            char C[][]=new char [max+1][n]; 
            for(int i=0; i<n; i++){
                for(int j=0; j<=max; j++){
                    C[j][i]='.';
                }
            }
            for(int i=0; i<n; i++){
                if(b[i]!=0){
                    if(inf[i]<i){
                        int aux=0;
                        for(int j=inf[i];j<i;j++){
                            C[aux][j]='\\';
                            aux++;
                        }
                    }
                    if(sup[i]>i){
                        int aux=0;
                        for(int j=sup[i];j>i;j--){
                            C[aux][j]='/';
                            aux++;
                        }
                    }
                }
            }
            
            for(int j=0; j<=max; j++){
                for(int i=0; i<n; i++){
                    System.out.print(C[j][i]);
                }
                System.out.println();
            }

        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=1;i<=t; i++){
            int n=in.nextInt();
            int b[]=new int[n];
            for(int j=0; j<n; j++){
                b[j]=in.nextInt();
            }
            solve(n, b, i);
        }



    }

}