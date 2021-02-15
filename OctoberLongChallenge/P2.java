import java.util.Scanner;


class P2 {

    public static long dSum(long n){
        long sum=0;
        while(n>0){
            sum+=(n%10);
            n/=10;
        }
        return sum;   
    }

    public static long tree(long n, long d, long lim, long goal, long lim1){
        if(lim==0){
            return n==goal?0:1000000;
        }else{
            if(n==goal){
                return 0;
            }else{
                
                long a1=lim1==0?1000000:tree(n+d,d, lim-1, goal, lim1-1);
                long a2=tree(dSum(n),d, lim-1, goal, lim1);
                return 1+Math.min(a1,a2);
            }
        }
    }



    public static void solve(long n, long d){
        long min, dist=0, sumas=0, dOps=0;
        long aux= n;
        int caso=0;
        switch((int)(d%9)){
            case 3:
                min=(n%3);
                min=min==0?3:min;
                caso=1;
            break;
            case 6:
                min=(n%3);
                min=min==0?3:min;
                caso=1;
            break;
            case 0:
                min=(n%9);
                min=min==0?9:min;
                caso=2;
            break;
            default:
                min=1;
                caso=0;
            break;
        }
        while((aux%9)!=(min%9)){
            sumas++;
            aux+=d;
        }
        
        switch(caso){
            case 2:
                while(aux!=min){
                    aux=dSum(aux);
                    dist++;
                }
            break;
            case 1:
                while(aux!=min){
                    aux=dSum(aux);
                    dOps++;
                }
                
                dist=tree(n,d,sumas+dOps, min, sumas);
            break;
            case 0:
                while(aux!=min){
                    aux=dSum(aux);
                    dOps++;
                }
                dist=tree(n,d,sumas+dOps, min, sumas);
            break;
        }
        System.out.println(min+" "+dist);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0; i<t; i++){
            long n=in.nextLong();
            long d=in.nextLong();

            solve(n,d);

        }
    }
}