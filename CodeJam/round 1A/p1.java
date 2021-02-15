import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class p1{
    public static void solve2(int r0, int c0, boolean inv){
        if(inv){
            if(c0%2==1){
                System.out.println((c0+1)/2+" "+(r0+1));
            }
            for(int i=0; i<c0/2; i++){
                System.out.println((i+1)+" "+r0);
                System.out.println(((i+1)+(c0+1)/2)+" "+(r0+1));
            }
            if(c0%2==1){
                System.out.println((c0+1)/2+" "+r0);
            }
            for(int i=0; i<c0/2; i++){
                System.out.println((i+1)+" "+(r0+1));
                System.out.println(((i+1)+(c0+1)/2)+" "+r0);
            };
        }else{
            int aux=c0;
            c0=r0;
            r0=aux;
            if(r0%2==1){
                System.out.println((c0+1)+" "+(r0+1)/2);
            }
            for(int i=0; i<r0/2; i++){
                System.out.println((c0)+" "+(i+1));
                System.out.println((c0+1)+" "+((i+1)+(r0+1)/2));
            }
            if(r0%2==1){
                System.out.println(c0+" "+(r0+1)/2);
            }
            for(int i=0; i<r0/2; i++){
                System.out.println((c0+1)+" "+(i+1));
                System.out.println(c0+" "+((i+1)+(r0+1)/2));
            }
        }
        
    }

    public static void solve3(int r0, int c0, boolean inv){
        if(inv){
            if(c0%2==1){
                System.out.println((c0+1)/2+" "+(r0+1));
            }
            for(int i=0; i<c0/2; i++){
                System.out.println((i+1)+" "+r0);
                System.out.println(((i+1)+(c0+1)/2)+" "+(r0+1));
            }
            if(c0%2==1){
                System.out.println((c0+1)/2+" "+(r0+2));
            }
            for(int i=0; i<c0/2; i++){
                System.out.println((i+1)+" "+(r0+1));
                System.out.println(((i+1)+(c0+1)/2)+" "+(r0+2));
            }
            if(c0%2==1){
                System.out.println((c0+1)/2+" "+(r0));
            }
            for(int i=c0/2-1; i>0; i--){
                System.out.println((i+1)+" "+(r0+2));
                System.out.println(((i+1)+(c0+1)/2)+" "+r0);
            };
        }else{
            int aux=c0;
            c0=r0;
            r0=aux;
            if(r0%2==1){
                System.out.println((c0+1)+" "+(r0+1)/2);
            }
            for(int i=0; i<r0/2; i++){
                System.out.println((c0)+" "+(i+1));
                System.out.println((c0+1)+" "+((i+1)+(r0+1)/2));
            }
            if(r0%2==1){
                System.out.println(c0+" "+(r0+1)/2);
            }
            for(int i=0; i<r0/2; i++){
                System.out.println((c0+1)+" "+(i+1));
                System.out.println(c0+" "+((i+1)+(r0+1)/2));
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=1;i<=t; i++){
            int r=in.nextInt();
            int c=in.nextInt();
            if(r==1 || c==1){
                System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
            }else if(Math.max(r, c)<4){
                System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
            }else if((r==2 && c==4)||(r==4 && c==2)){
                System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
            }else{
                System.out.println("Case #"+(i+1)+": POSSIBLE");
                solve3(1,6,true);
            }
            
        }
    }
}