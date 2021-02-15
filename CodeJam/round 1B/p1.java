import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;



class p1{

    public static int upVal(int arr[], int x) 
    { 
        int i=0;
        while(i<arr.length && arr[i]<x){
            i++;
        }
        return i;
    }
    public static int downVal(int arr[], int x) 
    { 
        int i=0;
        while(i<arr.length && arr[arr.length-i-1]>x){
            i++;
        }
        return i;
    } 

    public static int solve(int[]up, int down[]){
        int max=upVal(up,0)+downVal(down, 0);
        int ans=0;
        
        for(int i=0; i<up.length; i++){
            int val=upVal(up,up[i]+1)+downVal(down, up[i]+1);
            if(max<val){
                max=val;
                ans=up[i]+1;
            }
        }

       

        return ans;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        
        for(int i=1;i<=t; i++){
            int p=in.nextInt();
            int q=in.nextInt();
            int cN=0, cS=0, cW=0, cE=0;
            int N[]=new int[500];
            int S[]=new int[500];
            int W[]=new int[500];
            int E[]=new int[500];
            for(int j=0; j<p; j++){
                int x=in.nextInt();
                int y=in.nextInt();
                String s=in.next();
                if(s.equals("N")){
                    N[cN]=y;
                    cN++;
                }
                if(s.equals("S")){
                    S[cS]=y;
                    cS++;
                }
                if(s.equals("W")){
                    W[cW]=x;
                    cW++;
                }
                if(s.equals("E")){
                    E[cE]=x;
                    cE++;
                }
                
            }
            
            N=Arrays.copyOf(N, cN);
            S=Arrays.copyOf(S, cS);
            W=Arrays.copyOf(W, cW);
            E=Arrays.copyOf(E, cE);
            Arrays.sort(N);
            Arrays.sort(S);
            Arrays.sort(W);
            Arrays.sort(E);
            
            int y=solve(N,S);
            int x=solve(E,W);
            System.out.println("Case #"+i+": "+x+" "+y);
        }
    }
}