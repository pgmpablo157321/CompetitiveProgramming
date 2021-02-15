import java.util.Scanner;


class P4 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        int max=1000000000;
        for(int i=0; i<t; i++){
            int a[]=new int[7];
            System.out.println("Q 0 0");
            a[0]=in.nextInt();
            if(a[0]==0){
                System.out.println("Q "+max+" 0");
                a[1]=in.nextInt();
                System.out.println("Q 0 "+max);
                a[2]=in.nextInt();
                System.out.println("A 0 0 "+(max-a[1])+" "+(max-a[2]));
            }else if(a[0]<=max){
                int x0,y0,x1,y1;
                System.out.println("Q "+a[0]+" 0");
                a[1]=in.nextInt();
                System.out.println("Q 0 "+a[0]);
                a[2]=in.nextInt();
                System.out.println("Q "+(a[0]-(a[1]+1)/2)+" "+(a[1]+1)/2);
                a[3]=in.nextInt();
                System.out.println("Q "+(a[2]+1)/2+" "+(a[0]-(a[2]+1)/2));
                a[4]=in.nextInt();
                y0=(a[1]+1)/2+a[3];
                x0=(a[2]+1)/2+a[4];

                System.out.println("Q "+max+" "+y0);
                a[5]=in.nextInt();
                System.out.println("Q "+x0+" "+max);
                a[6]=in.nextInt();
                y1=max-a[6];
                x1=max-a[5];
                System.out.println("A "+x0+" "+y0+" "+x1+" "+y1);
            }else{
                int x0,y0,x1,y1;
                System.out.println("Q "+max+" "+(a[0]-max));
                a[1]=in.nextInt();
                System.out.println("Q "+(a[0]-max)+" "+max);
                a[2]=in.nextInt();
                System.out.println("Q "+(max-(a[1]+1)/2)+" "+((a[0]-max)+(a[1]+1)/2));
                a[3]=in.nextInt();
                System.out.println("Q "+((a[0]-max)+(a[2]+1)/2)+" "+(max-(a[2]+1)/2));
                a[4]=in.nextInt();
                y0=(a[0]-max)+(a[1]+1)/2+a[3];
                x0=(a[0]-max)+(a[2]+1)/2+a[4];

                System.out.println("Q "+max+" "+y0);
                a[5]=in.nextInt();
                System.out.println("Q "+x0+" "+max);
                a[6]=in.nextInt();
                y1=max-a[6];
                x1=max-a[5];
                System.out.println("A "+x0+" "+y0+" "+x1+" "+y1);
            }
            if(in.nextInt()==-1){
                i=t;
            }
        }
    }
}