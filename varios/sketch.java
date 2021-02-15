import java.util.Scanner;


class sketch{

    public static double lim(int n){
        double x=1.0/n;
        for(int i=n+1; i<=n*2; i++){
            x*=Math.pow(i, (1.0/n));
        }


        return x;
    }




    public static void main(String[] args) {

        System.out.println(lim(100000000));
        System.out.println(Math.exp(2*Math.log1p(1)-1));

    }
}