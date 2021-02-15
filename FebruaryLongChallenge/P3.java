import java.util.Arrays;
import java.util.Scanner;


class P3 {

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
    
    
    public static long power(long x, long y, long p) 
    {
        long res = 1;      
         
        x = x % p;  
      
        while (y > 0) 
        { 
            if((y & 1)==1) 
                res = (res * x) % p; 
            y = y >> 1;  
            x = (x * x) % p;  
        } 
        return res; 
    } 


    public static long solve(int n, int k, int m){
        long mod=1000000007;
        long n0=n;
        long k0=k;
        long m0=m;
        long ans=0;
        if(m0%2==1){
            long D=power(n, (m+1)/2, mod);
            long N=power((n-1), (m+1)/2, mod);
            N=((D-N)+mod)%mod;
            ans=N*modInverse(D, mod);
            ans%=mod;
        }else{
            long D=power(n, m/2, mod);
            long N=power((n-1), m/2, mod);
            D*=(n+k);
            D%=mod;
            N*=(n+k-1);
            N%=mod;
            N=((D-N)+mod)%mod;
            ans=N*modInverse(D, mod);
            ans%=mod;

        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        
        int t=in.nextInt();
        for(int i=0; i<t; i++){
            int n= in.nextInt();
            int k=in.nextInt();
            int m=in.nextInt();
            System.out.println(solve(n, k, m));
        }       
    }
}
