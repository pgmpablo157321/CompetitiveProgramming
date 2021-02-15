import java.util.Arrays;
import java.util.Scanner;

class Fsol{

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0; i<t; i++){
            int n=in.nextInt();
            int a=0;
            int b=0;
            int p=1;
            int count=0;
            while(n>0){
                switch(n%10){
                    case 0:

                    break;
                    case 1:
                        if(count%2==0){
                            a+=p;
                        }else{
                            b+=p;
                        }
                        count++;
                    break;
                    case 2:
                        a+=p;
                        b+=p;
                    break;
                    case 3:
                        a+=2*p;
                        b+=p;
                    break;
                    case 4:
                        a+=3*p;
                        b+=p;
                    break;
                    case 5:
                        a+=3*p;
                        b+=2*p;
                    break;
                    case 6:
                        a+=5*p;
                        b+=p;
                    break;
                    case 7:
                        a+=6*p;
                        b+=p;
                    break;
                    case 8:
                        a+=7*p;
                        b+=p;
                    break;
                    case 9:
                        a+=8*p;
                        b+=p;
                    break;
                }
                p*=10;
                n/=10;
            }
            if(b!=0){
                System.out.println(a+" "+b);
            }else{
                System.out.println(a/2+" "+a/2);
            }
        }

    }


}