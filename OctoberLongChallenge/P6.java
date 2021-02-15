import java.util.Scanner;
import java.util.*;


class TrieNode {

    TrieNode children[];
    Hashtable<Integer, Integer> hijos;
    int index;
    int k;
    TrieNode(int m, int k){
        index=0;
        children=new TrieNode[m];
        hijos= new Hashtable<Integer, Integer>();
        this.k=k;
    }

    public void insert(int []a, int i) 
    { 
        if(i<a.length){
            if(this.hijos.containsKey(a[i])){
                int x=this.hijos.get(a[i]);
                this.children[x].insert(a, i+1);
            }else{
                hijos.put(a[i], index);
                children[index]=new TrieNode(this.children.length, a[i]);
                this.children[index].insert(a, i+1);
                index++;
            }
        }
    }

    public int nodes(){
        int ans=1;
        for(int i=0;i<index; i++){
            ans+=children[i].nodes();
        }
        return ans;
    }

    public String toString(){

        String ans= "("+String.valueOf(k)+" ";
        for(int i=0;i<index; i++){
            ans+=children[i].toString();
        }
        ans+=" )";
        return ans;
    }    
}

class P6 {

    public static long solve(int n, int m, int[][]a){
        long ans=0;
        for(int i=0; i<m; i++){
            for(int k=0; k<n; k++){
                TrieNode x=new TrieNode(n, -1);
                for(int j=k; j<n; j++){
                    x.insert(a[j], i);
                    ans+=(x.nodes()-1);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        int a[][]=new int [n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                a[i][j]=in.nextInt();
            }
        }
        int[]x=a[0];
        
        System.out.println(solve(n, m, a));
        
    }


}