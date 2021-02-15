import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class Node {
    public Queue<Node> children = new LinkedList<Node>();
    public Node parent;
    public int data, data2;
    public int index;
    public long zero=0;
    public long target=0;


    public Node(int[] a, int index, Queue<Integer>l[], Node Parent) {
        this.index = index;
        this.data = a[index];
        this.data2 = a[index];
        parent=Parent;
        while(!l[index].isEmpty()){
            if(this.parent==null || l[index].peek()!=this.parent.index){
                children.add(new Node(a, l[index].poll(), l, this));
            }else{
                l[index].poll();
            }
        }

    }

    
    public void acum(){
        int m=children.size();
        for(int i=0; i<m; i++){
            Node aux=children.poll();
            aux.acum();
            this.data^=aux.data;
            children.add(aux);
        }

    }
    public void reduce(int x){
        int m=children.size();
        for(int i=0; i<m; i++){
            Node aux=children.poll();
            aux.reduce(x);
            children.add(aux);
        }
        for(int i=0; i<m; i++){
            Node aux=children.poll();
            if(aux.data!=0 && aux.data != x){
                children.addAll(aux.children);
                this.data2^=aux.data2;
            }else{
                children.add(aux);
            }
            
        }
    }
    public void solve(int x, long mod){
        int m=children.size();
        if(children.size()==0){
            if(this.data==0){
                zero=1;
                target=0;
            }else{
                target=1;
                zero=0;
            }
        }else{
            for(int i=0; i<m; i++){
                Node aux=children.poll();
                aux.solve(x,mod);
                children.add(aux);
            }
            long t[]=new long[m];
            long z[]=new long[m];
            for(int i=0; i<m; i++){
                Node aux=children.poll();
                t[i]=aux.target;
                z[i]=aux.zero;
                children.add(aux);
            }
            long ans[]=operation(t, z, mod);
            if(this.data2==0){
                zero=ans[0];
                target=ans[1];
            }else{
                target=ans[0];
                zero=ans[1];
            }
        }
    }

    public static long[] operation(long t[], long z[], long mod){
        long ans[]=new long[2];
        ans[0]=1;
        ans[1]=0;
        for(int i=0; i<z.length; i++){
            long aux0=(z[i]+t[i])%mod;
            long aux1=(t[i])%mod;
            long b=ans[0];
            ans[0]=(ans[0]*aux0)%mod+(ans[1]*aux1)%mod;
            ans[1]=(b*aux1)%mod+(ans[1]*aux0)%mod;
            ans[0]%=mod;
            ans[1]%=mod;
        }
        return ans;

    }

    public long count(){
        long c=1;
        int m=children.size();
        for(int i=0; i<m; i++){
            Node aux=children.poll();
            c+=aux.count();
            children.add(aux);
        }
        return c;
    }


}




class P5 {
    
    public static long power(long x, long y, long p) 
    {
        long res = 1;      
         
        x = x % p;  
      
        while (y > 0) 
        { 
            if((y & 1)==1) 
                res = (res * x) % p; 
            y = y >> 1;  
            x = (x * x) % p;  
        } 
        return res; 
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int x=in.nextInt();
        int a[]=new int[n];
        Queue l[]=new LinkedList [n];
        for(int i=0; i<n; i++){
            l[i]=new LinkedList<Integer>();
        }
        for(int i=0; i<n; i++){
            a[i]=in.nextInt();
        }
        for(int i=0; i<n-1; i++){
            int ini=in.nextInt();
            int fin=in.nextInt();
            l[ini-1].add(fin-1);
            l[fin-1].add(ini-1);
        }
        
        Node tree=new Node(a, 0, l, null);
        long mod=1000000007;
        tree.acum();
        if(tree.data!=x && tree.data!=0){
            System.out.println(0);
        }else if(x!=0){
            tree.reduce(x);
            tree.solve(x, mod);
            System.out.println(tree.target);
        }else{
            tree.reduce(x);
            System.out.println(power(2, tree.count()-1, mod));
        }
        




    }
}