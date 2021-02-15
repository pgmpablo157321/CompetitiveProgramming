import java.util.Arrays;
import java.util.Scanner;

class Ycan{

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0; i<t; i++){
            int n=in.nextInt();
            char bp[]=in.next().toCharArray();
            for(int j=0;j<bp.length;j++){
                if(bp[j]=='E'){
                    bp[j]='S';
                }else{
                    bp[j]='E';
                }
            }
            System.out.print("Case #"+(i-1)+": ");
            for(int j=0;j<bp.length;j++){
                System.out.print(bp[j]);
            }
            System.out.println();
        }

    }


}