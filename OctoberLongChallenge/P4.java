import java.util.Scanner;
import java.util.*;

class P4 {

    public static long modInverse(long a, long m){
            
        long m0 = m; 
        long y = 0, x = 1; 
        if (m == 1) 
            return 0; 
        while (a > 1){  
            long q = a / m; 
            long t = m; 
            m = a % m;
            a = t; 
            t = y; 
            y = x - q * y; 
            x = t; 
        } 
        while (x < 0) 
            x += m0; 
        
        return x; 
    } 


    public static long solve(long n, long k){
        long ans=0;
        if(k>n){
            return 0;
        }else{
            long mod=1000000007;
            long a=1;
            long b=1;
            long c=1;
            long d=(n-k+1)%mod;
            long e=2;
            for(int i=1; i<=k; i++){
                long aux=d*e;
                aux%=mod;
                aux*=c;
                aux%=mod;
                aux*=modInverse(a, mod);
                aux%=mod;
                aux*=modInverse(b, mod);
                aux%=mod;
                ans+=aux;
                ans%=mod;
                a*=i+1;
                a%=mod;
                b*=i;
                b%=mod;
                c*=(k-i);
                c%=mod;
                d*=((n-k+1-i)%mod);
                d%=mod;
                e*=2;
                e%=mod;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0; i<t; i++){
            long n=in.nextLong();
            long k=in.nextLong();
            System.out.println(solve(n,k));

        }

    }
}