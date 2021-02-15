import java.util.Scanner;

class alienLanguajes {

    public static long solve(int n, int m){
        long mod=100000007;
        long a[][]=new long [n][m];
        long s[][]=new long [n][m];
        for(int i=0; i<n; i++){
            a[i][m-1]=2*(i+1)>n?1:0;
            s[i][m-1]=i>0? s[i-1][m-1]+a[i][m-1]:a[i][m-1];
            a[i][m-1]%=mod;
            s[i][m-1]%=mod;
        }

        for(int i=m-2; i>=0; i--){
            for(int j=0; j<n; j++){
                a[j][i]=2*(j+1)>n?s[n-1][i+1]:((s[n-1][i+1]-s[2*j][i+1])+mod)%mod;
                a[j][i]%=mod;
                s[j][i]=j>0?s[j-1][i]+a[j][i]:a[j][i];
                s[j][i]%=mod;
            }
        }


        return s[n-1][0];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0; i<t; i++){
            int n=in.nextInt();
            int m=in.nextInt();
           
            System.out.println(solve(n, m));
        }




    }
}