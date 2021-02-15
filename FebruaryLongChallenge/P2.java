import java.util.Arrays;
import java.util.Scanner;


class P2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0; i<t; i++){
            String s=in.next();
            char[]c=s.toCharArray();
            int []x=new int[26];
            for(int j=0; j<c.length; j++){
                x[c[j]-65]++;
            }
            Arrays.sort(x);
            int ans=Integer.MAX_VALUE;
            for(int j=1; j<=26; j++){
                if(c.length%j==0){
                    int aux[]=new int[26];
                    int aux2=0;
                    for(int k=0; k<j; k++){
                        aux[25-k]=c.length/j;
                    }
                    for(int k=0; k<26; k++){
                        aux2+=Math.abs(x[k]-aux[k]);
                    }
                    if(ans>aux2){
                        ans=aux2;
                    }
                }
            }
            System.out.println(ans/2);
        }
    }
}