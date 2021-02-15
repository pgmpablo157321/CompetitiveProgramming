import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class p1{

    public static long[] digitos(long n){
        long[]digits=new long[(int)Math.log10(n)+1];
        int i=digits.length-1;
        while(n>0){
            digits[i]=n%10;
            n/=10;
            i--;
        }
        return digits;
    }

    public static long pow(long a, long b){
        long ans=1;
        for(int i=0; i<b; i++){
            ans*=a;
        }
        return ans;
    }


    public static long solve(long n){
        long[]digits=digitos(n);
        int i=0;
        while(digits[i]%2==0){
            i++;
            if(i==digits.length)
                return 0;
        }
        if(digits[i]!=9){
            long up=(digits[i]+1)*pow(10, digits.length-i-1);
            long down=(digits[i]-1)*pow(10, digits.length-i-1)+8*(pow(10, digits.length-i-1)-1)/9;
            long start=n%pow(10, digits.length-i);
            
            return Math.min(start-down, up-start);
        }else{
            
            return (n%pow(10, digits.length-i))-(8*pow(10, digits.length-i-1)+8*(pow(10, digits.length-i-1)-1)/9);
        }
        


    }

public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t=in.nextInt();
    for(int i=1;i<=t; i++){
        long n=in.nextLong();
        
        System.out.println("Case #"+i+": "+solve(n));
    }



    }

}