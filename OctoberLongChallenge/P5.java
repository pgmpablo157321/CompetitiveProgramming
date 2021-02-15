import java.util.Scanner;
import java.util.*;

class P6 {
    public static int GCD(int a, int b){
        int aux=0;
        while(b>0){
            aux=a;
            a=b;
            b=aux%b;
        }
        return a;
    }

    


    public static int solve(int n, int a[]){
        int ans=0;
        int ver=0;
        int aux=0;
        int m=0;
        int b[]=new int[n];
        Queue<Integer> l=new LinkedList<Integer>();
        //Queue<Integer> restantes= new LinkedList<Integer>();
        while(aux<n){
            while(aux<n && b[aux]!=0){
                aux++;
            }
            if(aux<n){
                b[aux]=1;
                l.add(aux);
                while(!l.isEmpty()){
                    m=l.poll();
                    for(int i=aux+1; i<n; i++){
                        if(b[i]==0 && GCD(a[i], a[m])==1){
                            l.add(i);
                            b[i]=1;
                        }
                    }
    
                }
                ans++;
            }
            
        }
        return ans;
    }


    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int n=in.nextInt();
        int a[]=new int[n];
        for(int i=0; i<n; i++){
            a[i]=in.nextInt();
        }
        System.out.println(solve(n,a));
    }
}