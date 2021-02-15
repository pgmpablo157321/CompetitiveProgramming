import java.util.Scanner;


class P1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int c=in.nextInt();
        int coins=1000;
        boolean broken=false;
        int i=Math.min(1000, n);
        int min=1, max=i;
        while(!broken && i<n){
            System.out.println("1 "+i);
            System.out.flush();
            int aux=in.nextInt();
            coins--;
            if(aux==1){
                broken=true;
                max=i;
                min=Math.max(i-1000, 1);
            }
            i+=1000;
        }
        if(broken){
            System.out.println("2");
            System.out.flush();
            broken=false;
            coins-=150;
        }else{
            min=Math.max(i-1000,1);
            max=n;
        }
        i=Math.min(min+10, max);
        while(!broken && i<max){
            System.out.println("1 "+i);
            System.out.flush();
            int aux=in.nextInt();
            coins--;
            if(aux==1){
                broken=true;
                max=i;
                min=Math.max(i-10, min);
            }
            i+=10;
        }
        if(broken){
            System.out.println("2");
            System.out.flush();
            broken=false;
            coins-=150;
        }else{
            min=Math.max(i-10,1);
        }
        i=min;
        while(i<=max && !broken){
            System.out.println("1 "+i);
            System.out.flush();
            int aux=in.nextInt();
            coins--;
            if(aux==1){
                broken=true;
                System.out.println("3 "+i);
                System.out.flush();
            }
            i++;
        }
        //System.out.println(coins);

    }
}