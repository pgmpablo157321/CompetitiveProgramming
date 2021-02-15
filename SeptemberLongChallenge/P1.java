import java.util.Scanner;

class P1{
    public static long solve(long n, long m){
        if(n == 1){
            if(m == 0){
                return 0;
            }
            if(m == 1){
                return 1;
            }
        }else if(n == 2){
            if(m == 1){
                return 1;
            }
            if(m <= 3){
                return 2;
            }
        }else{
            if (m < n - 1){
                return -1;
            }
            if (m <= n + 1){
                return 2;
            }
            if (m < 2*n){
                return 3;
            }
            if (m <= n*(n+1)/2){
                return (long)Math.ceil(2*(m-n)/(double)n)+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0; i<t; i++){
            long n=in.nextLong();
            long m=in.nextLong();
            System.out.println(solve(n, m));
        }
    }
}