import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class p1{
    public static String solve(int[][]mat, int A){
        
        String ans="";
        int l[]=new int [A];
        for(int i=0; i<A; i++){
            l[i]=i;
        }
        for(int i=0; i<500; i++){
            int a1=0;
            int a2=0;
            int a3=0;
            int act=0;
            for(int j=0; j<A; j++){
                if(l[j]!=-1){
                    if(mat[j][i]==1){
                        a1=1;
                    }
                    if(mat[j][i]==2){
                        a2=1;
                    }
                    if(mat[j][i]==3){
                        a3=1;
                    }
                } 
            }
            if(a1==1 && a2==1 && a3==1){
                return "IMPOSSIBLE";
            }
            if(a1==1 && a2==0){
                if(a3==0){
                    ans+="S";
                    act=2;
                }else{
                    ans+="P";
                    act=1;
                }
                
            }
            if(a2==1 && a3==0){
                if(a1==0){
                    ans+="R";
                    act=3;
                }else{
                    ans+="S";
                    act=2;
                }
                
            }
            if(a3==1 && a1==0){
                if(a2==0){
                    ans+="P";
                    act=1;
                }else{
                    ans+="R";
                    act=3;
                }
                
            }
            
            if(a1==0 && a2==0 && a3==0){
                i=500;
            }else{
                for(int j=0; j<A; j++){
                    if(mat[j][i]!=act){
                        l[j]=-1;
                    }
                }
            }
            
                
    
        }
    
            for(int j=0; j<A; j++){
                if(l[j]!=-1){
                    if(ans.length()==500){
                        return "IMPOSSIBLE";
                    }
                    if(mat[j][0]==1){
                        ans+='S';
                        j=A;
                    }
                    else if(mat[j][0]==2){
                        ans+='R';
                        j=A;
                    }
                    else if(mat[j][0]==3){
                        ans+='P';
                        j=A;
                    }
                } 
            }
        return ans;
        

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=1;i<=t; i++){
            int A=in.nextInt();
            int mat[][]=new int[A][500];
            for(int j=0; j<A; j++){
                char[]aux=in.next().toCharArray();
                for(int k=0; k<aux.length; k++){
                    if(aux[k]=='P'){
                        mat[j][k]=1;
                    }
                    if(aux[k]=='S'){
                        mat[j][k]=2;
                    }
                    if(aux[k]=='R'){
                        mat[j][k]=3;
                    }
                }
            }


            System.out.println("Case #"+i+": "+solve(mat, A));
        }
    }
}