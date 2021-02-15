import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class P8 {


    public static int solveD(Queue<Integer> l[], int k, int index, int n){
        Queue<Integer> sQ=new LinkedList<Integer>();
        boolean sA[]=new boolean[n];
        sA[index]=true;
        sQ.add(index);
        int count=1, d=0;
        int aux, aux2;
        while(count<=n-k){
            int m=sQ.size();
            for(int i=0;i<m;i++){
                aux=sQ.poll();
                int m1=l[aux].size();
                for(int j=0; j<m1; j++){
                    aux2=l[aux].poll();
                    if(sA[aux2]==false){
                        sQ.add(aux2);
                        sA[aux2]=true;
                        count++;
                    }
                    l[aux].add(aux2);
                }
            }
            d++;
        }

        return d-1;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int []k=new int[n];
        for(int i=0; i<n; i++){
            k[i]=in.nextInt();
        }
        Queue l[]=new LinkedList [n];
        for(int i=0; i<n; i++){
            l[i]=new LinkedList<Integer>();
        }
        for(int i=0; i<n-1; i++){
            int ini=in.nextInt();
            int fin=in.nextInt();
            l[ini-1].add(fin-1);
            l[fin-1].add(ini-1);
        }
        for(int i=0; i<n; i++){
            System.out.print(solveD(l, k[i],i, n)+" ");
        }
        System.out.println();


    }
}