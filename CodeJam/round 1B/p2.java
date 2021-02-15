import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class p2{
    public static long exp(long a, long b){
        long ans=1;
        for(int i=0; i<b; i++){
            ans*=a;
        }
        return ans;
    }

    public static long[] solve(long a, long b){
        long r[]=new long [6];
        r[5]=(a>>37)%128;
        r[4]=(a>>44)%128;
        r[3]=(a>>56)%128;
        r[0]=(b>>56)%128;
        r[1]=(b>>28)%128;
        b=b-r[3]*exp(2, 14);
        r[2]=(b>>18)%128;
        return r;

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        int w=in.nextInt();
        for(int i=1;i<=t; i++){
            System.out.println(224);
            long a=in.nextLong();
            System.out.println(56);
            long b=in.nextLong();
            long r[]=solve(a,b);
            System.out.print(r[0]+" "+r[1]+" "+r[2]+" "+r[3]+" "+r[4]+" "+r[5]);
            System.out.println();
            if(in.nextInt()==-1){
                i=t+1;
            };
        }
    }
}