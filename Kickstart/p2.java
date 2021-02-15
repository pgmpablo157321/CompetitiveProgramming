import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class p2{

    public static double solve(int n, int k,int[]v){
        Arrays.sort(v);
        double acum[]=new double[n+1];
        for(int i=n-1;i>=0; i--){
            acum[i]=v[i]+acum[i+1];
        }
        double ans[]=new double[k+1];
        ans[0]=acum[0]/n;
        for(int i=1;i<=k; i++){
            int index=bSearch(ans[i-1], v);
            double p=(n-index)/(double)n;
            ans[i]=ans[i-1]*(1-p)+acum[index]*p/(n-index);
        }
        return ans[k];

    }


    public static int bSearch(double x, int[]v){
        int l=0, r=v.length-1; 
        while (l<=r) { 
            int m=l+(r-l)/2;
            if (v[m]==x) 
                return m; 
            if (v[m]<x) 
                l=m+1; 
            else
                r=m-1; 
        }  
        return l; 
    }

public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t=in.nextInt();
    for(int i=1;i<=t; i++){
        int n=in.nextInt();
        int k=in.nextInt();
        int v[]=new int[n];
        for(int j=0;j<n; j++){
            v[j]=in.nextInt();
        }
        System.out.println("Case #"+i+": "+solve(n, k, v));
    }



    }

}