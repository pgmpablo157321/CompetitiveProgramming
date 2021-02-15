import java.util.Scanner;


class P1 {


    public static boolean possible(long x[], long b[], int n, long m, long lim){
        for(int i=0; i<n; i++){
            if(x[i]>lim){
                m-=((x[i]-lim+b[i]-1)/b[i]);
            }
            if(m<0){
                return false;
            }
        }
        return true;
    }


    public static long solve(long a[], long b[], int n, long m){
        Scanner in= new Scanner(System.in);
        long x[]=new long[n];
        long max=0;
        for(int i=0; i<n; i++){
            x[i]=a[i]*b[i];
            if(max<x[i]){
                max=x[i];
            }
        }
        long act=max/2, sup=max, inf=0;
        while(sup>act){
            if(possible(x,b,n,m,act)){
                sup=act;
                act=(act+inf)/2;
            }else{
                inf=act;
                act=(act+sup+1)/2;
            }
        }
        return sup;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        long m=in.nextLong();
        long a[]=new long [n];
        long b[]=new long [n];
        for(int i=0; i<n; i++){
           a[i]=in.nextLong();
        }
         for(int i=0; i<n; i++){
           b[i]=in.nextLong();
        }
        System.out.println(solve(a,b,n,m));




    }
}