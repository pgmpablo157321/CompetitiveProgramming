import java.util.Arrays;
import java.util.Scanner;

class stringReduction{


    static int stringReductions(String s) {
        char c[]=s.toCharArray();
        int x1=0, x2=0, x3=0;
        for(int i=0; i<c.length;i++){
            if(c[i]=='a'){
                x1++;
            }else if(c[i]=='b'){
                x2++;
            }else{
                x3++;
            }
        }
        if((x1==0&&x2==0)||(x2==0&&x3==0)||(x1==0&&x3==0)){
            return c.length;
        }
        if(((x1+x2)%2==1)||((x1+x3)%2==1)||((x2+x3)%2==1)){
            return 1;
        }
        return 2;
    }


    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0; i<t; i++){
            String s=in.next();
            System.out.println(stringReductions(s));
        }
       
        
        
    }
}