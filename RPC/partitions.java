
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;


class partitions {

    public static int[] initialize(int n){
        int a[]=new int[n+1];
        int b[]=new int[n+1];
        int m=1000000007;
        for(int i=0; i<=n; i++){
            a[i]=1;
        }
        for(int i=2; i<=n; i++){
            for(int j=(n-(n%i)); j>=0; j-=i){
                for(int k=j; k<=n; k++){
                    b[k]+=a[k-j];
                    b[k]%=m;
                }
            }
            for(int j=0; j<n; j++){
                a[j]=b[j];
                b[j]=0;
            }
        }

        return a;
    }
    public static void main(String[] args) {
        int a[]=initialize(10000);
        Scanner in = new Scanner(System.in);

        Long T=System.currentTimeMillis();
        while(true){
            System.out.println(a[in.nextInt()]);
            if(System.currentTimeMillis()-T>4){
                break;
            }
        }
    
        
    }

}