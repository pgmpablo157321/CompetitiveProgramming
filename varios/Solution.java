import java.util.Scanner;

public class Solution {

    public static boolean solve(int[]a){
        int sum=1*a[1]+2*a[2]+3*a[3];
        sum%=4;
        boolean win[][][][]= new boolean[a[0]+1][a[1]+1][a[2]+1][a[3]+1];
        for(int x0=0;x0<=a[0];x0++){
            for(int x1=0;x1<=a[1];x1++){
                for(int x2=0;x2<=a[2];x2++){
                    for(int x3=0;x3<=a[3];x3++){
                        if(((sum-(x1+x2*2+x3*3)%4)+4)%4==2){
                            win[x0][x1][x2][x3]=true;
                        }else if (x0==0 && x1==0 && x2 == 0 && x3 == 0){
                            win[x0][x1][x2][x3]=false;
                        }else{
                            boolean aux0 = x0>0?win[x0-1][x1][x2][x3]:true;
                            boolean aux1 = x1>0?win[x0][x1-1][x2][x3]:true;
                            boolean aux2 = x2>0?win[x0][x1][x2-1][x3]:true;
                            boolean aux3 = x3>0?win[x0][x1][x2][x3-1]:true;
                            win[x0][x1][x2][x3]=!aux0 || !aux1 || !aux2 || !aux3;
                        }
                    }
                }
            }
        }

        return win[a[0]][a[1]][a[2]][a[3]];
    }

    public static void main(String[] args) {
        /* Enter your code here. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int j=0; j<t ;j++){
            int n=in.nextInt();
            int a[]=new int[4];
            int sum=0;
            for(int i=0; i<n; i++){
                int aux=in.nextInt();
                a[aux%4]++;
            }
            if(solve(a)){
                System.out.println("Ghayeeth");
            }else{
                System.out.println("Siroj");
            }
        }
    }
}