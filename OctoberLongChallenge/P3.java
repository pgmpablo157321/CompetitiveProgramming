import java.util.Scanner;


class P3 {


    public static int Search(int arr[], int x) 
    { 
        for(int i=arr.length-1; i>0; i--){
            if(x>=arr[i]){
                return i;
            }
        }
        return 0;
    } 

    public static int initialize(int[][]acc1, int[][]acc2, int n, int m, int size){
        int ans=Integer.MAX_VALUE;
        int b=((size+1)*(size+1))/2;
        int c=((size+1)*(size+1)+1)/2;
        int BlancasPares=0;
        int BlancasImpares=0;
        for(int i=0; i<n-size; i++){
            for(int j=0; j<m-size; j++){
                BlancasPares=acc1[i+size][j+size];
                BlancasImpares=acc2[i+size][j+size];
                if(i>0){
                    BlancasPares-=acc1[i-1][j+size];
                    BlancasImpares-=acc2[i-1][j+size];
                }
                if(j>0){
                    BlancasPares-=acc1[i+size][j-1];
                    BlancasImpares-=acc2[i+size][j-1];
                }
                if(i>0 && j>0){
                    BlancasPares+=acc1[i-1][j-1];
                    BlancasImpares+=acc2[i-1][j-1];
                }
                int aux=0;
                if((i+j)%2==0){
                    aux=Math.min(c-BlancasPares+BlancasImpares, b-BlancasImpares+BlancasPares);
                }else{
                    aux=Math.min(b-BlancasPares+BlancasImpares, c-BlancasImpares+BlancasPares);
                }
                if(aux<ans){
                    ans=aux;
                }
                
            }
        }


        return ans;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        int a[][]=new int[n][m];
        int acc1[][]=new int[n][m];
        int acc2[][]=new int[n][m];
        for(int i=0; i<n; i++){
            char aux[]=in.next().toCharArray();
            for(int j=0; j<m; j++){
                a[i][j]=aux[j]-48;
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                acc1[i][j]=0;
                acc2[i][j]=0;
                if(i>0){
                    acc1[i][j]+=acc1[i-1][j];
                    acc2[i][j]+=acc2[i-1][j];
                }
                if(j>0){
                    acc1[i][j]+=acc1[i][j-1];
                    acc2[i][j]+=acc2[i][j-1];
                }
                if(i>0 && j>0){
                    acc1[i][j]-=acc1[i-1][j-1];
                    acc2[i][j]-=acc2[i-1][j-1];
                }
                if((j+i)%2==0 && a[i][j]==1){
                    acc1[i][j]++;
                }
                if((j+i)%2==1 && a[i][j]==1){
                    acc2[i][j]++;
                }

            }
        }
        int ans[]=new int[Math.min(n, m)];
        for(int i=0; i<ans.length; i++){
            ans[i]=initialize(acc1, acc2, n, m, i);
        }
        int q=in.nextInt();
        int c[]=new int [q];
        for(int i=0; i<q; i++){
            c[i]=in.nextInt();
        }
        for(int i=0; i<q; i++){
            System.out.println(Search(ans,c[i])+1);
        }

    }
}