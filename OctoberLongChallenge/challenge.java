import java.util.Random;
import java.util.Scanner;


class challenge {


    public static void answer(){
        Scanner in = new Scanner(System.in);
        int c = in.nextInt();
        for(int x=0; x<c; x++){
            int n =  in.nextInt();
            int t, y;
            double z=0, Z=10;
            double coins=10, tugreks=0;
            for(int i=0; i<100; i++){
                t = in.nextInt();
                y = in.nextInt();
                z = in.nextDouble();
                System.out.println(0);
            }
            if(Z>z){
                int i=100;
                while(coins>0){
                    t = in.nextInt();
                    y = in.nextInt();
                    z = in.nextDouble();
                    i++;
                    if(t==1){
                        System.out.println(Math.min(coins, y));
                        tugreks+=Math.min(coins, y)*z;
                        tugreks-=(0.0005*Math.min(coins, y)*z);
                        coins-=Math.min(coins, y);
                    }else{
                        System.out.println(0);
                    }
                }
                for(int j=i; j<9970; j++){
                    t = in.nextInt();
                    y = in.nextInt();
                    z = in.nextDouble();
                    System.out.println(0);
                }
                for(int j=9970; j<10000; j++){
                    t = in.nextInt();
                    y = in.nextInt();
                    z = in.nextDouble();
                    if(t==1){
                        System.out.println(Math.min(tugreks/z, y));
                        coins+=Math.min(tugreks/z, y);
                        tugreks-=Math.min(tugreks, y*z);
                    }else{
                        System.out.println(0);
                    }
                }
            }else{
                for(int i=101; i<10000; i++){
                    t = in.nextInt();
                    y = in.nextInt();
                    z = in.nextDouble();
                    System.out.println(0);
                }
            }
        }
        
        

    }
    
    public static void main(String[] args) {
        answer();
        


    }

}