import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class RoundingError{

public static int gcd(int a, int b){
    int aux=0;
    while(b>0){
        aux=a;
        a=b;
        b=aux%b;
    }
    return a;
}



public static int solve(int n, int l, int c[]){
    final int n0=n;
    final int x0=100%n0;
    int s[]=new int[n];
    int sum=0;
    for(int i=0; i<l; i++){
        s[i]=(c[i]*x0)%n;
        sum+=c[i];
    }
    int current=l;
    PriorityQueue<Integer>a=new PriorityQueue<>(l,new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return (s[o2]-(n0+1)/2+n0)%n0-(s[o1]-(n0+1)/2+n0)%n0;
        }
    });
    for(int i=0; i<l; i++){
        a.add(i);
    }
    for(int i=0; i<n-sum; i++){
        
        if((((s[a.peek()]-(n0+1)/2)%n0+n0)%n0)>(-(n0+1)/2+n0)%n0){
            
            int aux=a.poll();
            s[aux]+=x0;
            c[aux]+=1;
            a.add(aux);
        }else{
            c[current]+=1;
            s[current]+=x0;
            a.add(current);
            current++;

        }
        
    }
    int ans=0;
    
    for(int i=0; i<n; i++){
        ans+=Math.round((c[i]*100)/(float)n);
    }
    return ans;
}

public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t=in.nextInt();
    for(int i=1;i<=t; i++){
        int n=in.nextInt();
        int l=in.nextInt();
        int[]c=new int[n];
        for(int j=0; j<l; j++){
            c[j]=in.nextInt();
        }
        System.out.println("Case #"+i+": "+solve(n, l, c));
    }



    }

}