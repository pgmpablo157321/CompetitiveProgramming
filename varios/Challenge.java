import java.util.Scanner;
import java.util.Hashtable;
import java.util.Random;

class Challenge {
	
	public static int argmax(int arr[], int n) {
		int ans=0;
		int max=0;
		for(int i=0; i<n; i++) {
			if (arr[i]>max) {
				max=arr[i];
				ans=i;
			}
		}
		return ans;
	}
	
	
	public static int argmax2(int arr[], int n, boolean visited[]) {
		int ans=-1;
		int max=-1;
		for(int i=0; i<n; i++) {
			if ((!visited[i]) && (arr[i]>max)) {
				max=arr[i];
				ans=i;
			}
		}
		return ans;
	}
	
	
	
	public static int[] getPermutationX(int mat[][][], int n) {
		int s[]=new int[n];
		int p[]=new int[n];
		boolean visited[] = new boolean[n];
		
		for(int i=0; i<n; i++) {
			if(mat[i][0][0]==0) {
				int j=0, k=0;
				int kmax=n-1;
                while((j<n) && (mat[i][j][0]==0)){
                    while((k<=kmax) && (mat[i][j][k]==0)){
                        k++;
                        s[i]+=1000/Math.pow(2, j+k);
					}
					if(k<kmax){
						kmax=k;
					}
                    k=0;
                    j++;
                }
			}
		}
		
		for(int i=0; i<n; i++) {
			p[i]=argmax2(s, n, visited);
			visited[p[i]]=true;
		}
		
		return p;
	}
	
	
	
	public static int[] getPermutationY(int mat[][][], int n) {
		int s[]=new int[n];
		int p[]=new int[n];
		boolean visited[] = new boolean[n];
		
		for(int j=0; j<n; j++) {
			if(mat[0][j][0]==0) {
				int i=0, k=0;
				int kmax=n-1;
                while((i<n)&&(mat[i][j][0]==0)){
                    while((k<=kmax)&&(mat[i][j][k]==0)){
                        k++;
                        s[j]+=1000/Math.pow(2, i+k);;
					}
					if(k<kmax){
						kmax=k;
					}
                    k=0;
                    i++;
                }
			}
		}
		
		for(int j=0; j<n; j++) {
			p[j]=argmax2(s, n, visited);
			visited[p[j]]=true;
		}
		
		
		return p;
	}
	
	
	public static int[] getPermutationZ(int mat[][][], int n) {
		int s[]=new int[n];
		int p[]=new int[n];
		boolean visited[] = new boolean[n];
		
		for(int k=0; k<n; k++) {
			if(mat[0][0][k]==0) {
				int jmax=n-1;
				int j=0, i=0;
                while((i<n)&&(mat[i][0][k]==0)){
                    while((j<=jmax)&&(mat[i][j][k]==0)){
                        j++;
                        s[k]+=1000/Math.pow(2, i+j);;
					}
					if(j<jmax){
						jmax=j;
					}
                    j=0;
                    i++;
                }
			}
		}
		
		for(int k=0; k<n; k++) {
			p[k]=argmax2(s, n, visited);
			visited[p[k]]=true;
		}
		
		
		return p;
	}
	
	
	public static int eval(int[][][]mat, int px[], int py[], int pz[], int n) {
		int [][][]mat2=new int[n][n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				for(int k=0; k<n; k++) {
					if(mat[px[i]][py[j]][pz[k]]==1) {
						mat2[i][j][k]=1;
					}
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				for(int k=0; k<n; k++) {
					if(mat2[i][j][k]==1) {
						if(i<n-1) {
							mat2[i+1][j][k]=1;
						}
						if(j<n-1) {
							mat2[i][j+1][k]=1;
						}
						if(k<n-1) {
							mat2[i][j][k+1]=1;
						}
						
					}
					
				}
			}
		}
		int ans=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				for(int k=0; k<n; k++) {
					if(mat2[i][j][k]==0) {
						ans++;
					}
					
				}
			}
		}
		
		return ans;
	}
	
	public static int[][] completePermutationX(int mat[][][], int n, int px[]){
		int sj[]=new int[n];
		int pj[]=new int[n];
		boolean visitedj[] = new boolean[n];
		
		int sk[]=new int[n];
		int pk[]=new int[n];
		boolean visitedk[] = new boolean[n];

		boolean tj=false;
		boolean tk=false;

		int inij=n;
		int inik=n;

		for(int j=0; j<n; j++) {
			if(!tj){
				if(mat[px[0]][j][0]==0) {
					pj[j]=j;
					visitedj[j]=true;
				}else{
					inij=j;
					tj=true;
					int i=0, k=0;
					int kmax=n-1;
					while((i<n)&&(mat[px[i]][j][0]==0)){
						while((k<=kmax)&&(mat[px[i]][j][k]==0)){
							k++;
							sj[j]+=1000/Math.pow(2, i+k);;
						}
						if(k<kmax){
							kmax=k;
						}
						k=0;
						i++;
					}
				}
			}else{
				int i=0, k=0;
				int kmax=n-1;
				while((i<n)&&(mat[px[i]][j][0]==0)){
					while((k<=kmax)&&(mat[px[i]][j][k]==0)){
						k++;
						sj[j]+=1000/Math.pow(2, i+k);;
					}
					if(k<kmax){
						kmax=k;
					}
					k=0;
					i++;
				}
			}
			
		}

		for(int j=inij; j<n; j++) {
			pj[j]=argmax2(sj, n, visitedj);
			visitedj[pj[j]]=true;
		}
		

		for(int k=0; k<n; k++) {
			if(!tk){
				if(mat[px[0]][0][k]==0) {
					pk[k]=k;
					visitedk[k]=true;
				}else{
					inik=k;
					tk=true;
					int i=0, j=0;
					int jmax=n-1;
					while((i<n)&&(mat[px[i]][0][k]==0)){
						while((j<=jmax)&&(mat[px[i]][j][k]==0)){
							j++;
							sk[k]+=1000/Math.pow(2, i+j);;
						}
						if(j<jmax){
							jmax=j;
						}
						j=0;
						i++;
					}
				}
			}else{
				int i=0, j=0;
				int jmax=n-1;
				while((i<n)&&(mat[px[i]][0][k]==0)){
					while((j<=jmax)&&(mat[px[i]][j][k]==0)){
						j++;
						sk[k]+=1000/Math.pow(2, i+j);;
					}
					if(j<jmax){
						jmax=j;
					}
					j=0;
					i++;
				}
			}
		}

		for(int k=inik; k<n; k++) {
			pk[k]=argmax2(sk, n, visitedk);
			visitedk[pk[k]]=true;
		}
		int ans[][]=new int[2][n];
		ans[0]=pj;
		ans[1]=pk;


		return ans;
	}
	

	public static int[][] completePermutationY(int mat[][][], int n, int px[]){
		int si[]=new int[n];
		int pi[]=new int[n];
		boolean visitedi[] = new boolean[n];
		
		int sk[]=new int[n];
		int pk[]=new int[n];
		boolean visitedk[] = new boolean[n];

		boolean ti=false;
		boolean tk=false;

		int inii=n;
		int inik=n;

		for(int i=0; i<n; i++) {
			if(!ti){
				if(mat[i][px[0]][0]==0) {
					pi[i]=i;
					visitedi[i]=true;
				}else{
					inii=i;
					ti=true;
					int j=0, k=0;
					int kmax=n-1;
					while((j<n)&&(mat[i][px[j]][0]==0)){
						while((k<=kmax)&&(mat[i][px[j]][k]==0)){
							k++;
							si[i]+=1000/Math.pow(2, j+k);
						}
						if(k<kmax){
							kmax=k;
						}
						k=0;
						j++;
					}
				}
			}else{
				int j=0, k=0;
				int kmax=n-1;
				while((j<n)&&(mat[i][px[j]][0]==0)){
					while((k<=kmax)&&(mat[i][px[j]][k]==0)){
						k++;
						si[i]+=1000/Math.pow(2, j+k);
					}
					if(k<kmax){
						kmax=k;
					}
					k=0;
					j++;
				}
			}
			
		}

		for(int i=inii; i<n; i++) {
			pi[i]=argmax2(si, n, visitedi);
			visitedi[pi[i]]=true;
		}
		

		for(int k=0; k<n; k++) {
			if(!tk){
				if(mat[0][px[0]][k]==0) {
					pk[k]=k;
					visitedk[k]=true;
				}else{
					inik=k;
					tk=true;
					int i=0, j=0;
					int jmax=n-1;
					while((i<n)&&(mat[i][px[0]][k]==0)){
						while((j<=jmax)&&(mat[i][px[j]][k]==0)){
							j++;
							sk[k]+=1000/Math.pow(2, i+j);
						}
						if(j<jmax){
							jmax=j;
						}
						j=0;
						i++;
					}
				}
			}else{
				int i=0, j=0;
				int jmax=n-1;
				while((i<n)&&(mat[i][px[0]][k]==0)){
					while((j<=jmax)&&(mat[i][px[j]][k]==0)){
						j++;
						sk[k]+=1000/Math.pow(2, i+j);
					}
					if(j<jmax){
						jmax=j;
					}
					j=0;
					i++;
				}
			}
		}

		for(int k=inik; k<n; k++) {
			pk[k]=argmax2(sk, n, visitedk);
			visitedk[pk[k]]=true;
		}
		int ans[][]=new int[2][n];
		ans[0]=pi;
		ans[1]=pk;


		return ans;
	}
	

	public static int[][] completePermutationZ(int mat[][][], int n, int px[]){
		int sj[]=new int[n];
		int pj[]=new int[n];
		boolean visitedj[] = new boolean[n];
		
		int si[]=new int[n];
		int pi[]=new int[n];
		boolean visitedi[] = new boolean[n];

		boolean tj=false;
		boolean ti=false;

		int inij=0;
		int inii=0;

		for(int j=0; j<n; j++) {
			if(!tj){
				if(mat[0][j][px[0]]==0) {
					pj[j]=j;
					visitedj[j]=true;
				}else{
					inij=j;
					tj=true;
					int i=0, k=0;
					int kmax=n-1;
					while((i<n)&&(mat[i][j][px[0]]==0)){
						while((k<=kmax)&&(mat[i][j][px[k]]==0)){
							k++;
							sj[j]+=1000/Math.pow(2, i+k);
						}
						if(k<kmax){
							kmax=k;
						}
						k=0;
						i++;
					}
				}
			}else{
				int i=0, k=0;
				int kmax=n-1;
				while((i<n)&&(mat[i][j][px[0]]==0)){
					while((k<=kmax)&&(mat[i][j][px[k]]==0)){
						k++;
						sj[j]+=1000/Math.pow(2, i+k);
					}
					if(k<kmax){
						kmax=k;
					}
					k=0;
					i++;
				}
			}
			
		}

		for(int j=inij; j<n; j++) {
			pj[j]=argmax2(sj, n, visitedj);
			visitedj[pj[j]]=true;
		}
		

		for(int i=0; i<n; i++) {
			if(!ti){
				if(mat[i][0][px[0]]==0) {
					pi[i]=i;
					visitedi[i]=true;
				}else{
					inii=i;
					ti=true;
					int j=0, k=0;
					int kmax=n-1;
					while((j<n)&&(mat[i][j][px[0]]==0)){
						while((k<=kmax)&&(mat[i][j][px[k]]==0)){
							k++;
							si[i]+=1000/Math.pow(2, j+k);
						}
						if(k<kmax){
							kmax=k;
						}
						k=0;
						j++;
					}
				}
			}else{
				int j=0, k=0;
				int kmax=n-1;
				while((j<n)&&(mat[i][j][px[0]]==0)){
					while((k<=kmax)&&(mat[i][j][px[k]]==0)){
						k++;
						si[i]+=1000/Math.pow(2, j+k);
					}
					if(k<kmax){
						kmax=k;
					}
					k=0;
					j++;
				}
			}
			
		}

		for(int i=inii; i<n; i++) {
			pi[i]=argmax2(si, n, visitedi);
			visitedi[pi[i]]=true;
		}
		int ans[][]=new int[2][n];
		ans[0]=pi;
		ans[1]=pj;


		return ans;
	}

	public static void main(String[] args) {


		// Random randomNum = new Random();
		
		// int n=100;
		// int mat[][][]=new int[n][n][n];
		// for(int i=0; i<n; i++) {
		// 	for(int j=0; j<n; j++) {
		// 		for(int k=0; k<n; k++) {
		// 			mat[i][j][k] = randomNum.nextInt(2);
		// 			//System.out.println(mat[i][j][k]);
		// 		}
		// 	}
        // }
        
        Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int mat[][][] = new int [n][n][n];
		for(int i=0; i<n*n; i++) {
			char[]c=in.next().toCharArray();
			for(int j=0; j<n; j++) {
				if(c[j]=='1') {
					mat[j][i%n][i/n]=1;
				}
			}
		}
		
		
		
		int []px1 = getPermutationX(mat, n);
		int cx[][]=completePermutationX(mat, n, px1);
		int []py1 = cx[0];
        int []pz1 = cx[1];
        

        int eval1=eval(mat, px1, py1, pz1, n);

        
		int []py2 = getPermutationY(mat, n);
		int cy[][]=completePermutationY(mat, n, py2);
		int []px2 = cy[0];
        int []pz2 = cy[1];

        int eval2=eval(mat, px2, py2, pz2, n);

		int []pz3 = getPermutationZ(mat, n);
		int cz[][]=completePermutationX(mat, n, pz3);
        int []px3 = cz[0];
		int []py3 = cz[1];
        

        int eval3=eval(mat, px3, py3, pz3, n);


        int []px = new int[n];
		int []py = new int[n];
        int []pz = new int[n];

        if ((eval1>eval2)&&(eval1>eval3)){
            px=px1;
            py=py1;
            pz=pz1;
        }else if ((eval1<eval2)&&(eval2>eval3)){
            px=px2;
            py=py2;
            pz=pz2;
        }else{
            px=px3;
            py=py3;
            pz=pz3;
        }
		
		for(int i=0;i<n;i++) {
			if(i<n-1) {
				System.out.print((px[i]+1)+" ");
			}else {
				System.out.print((px[i]+1));
			}
			
		}
		System.out.println();
		for(int i=0;i<n;i++) {
			if(i<n-1) {
				System.out.print((py[i]+1)+" ");
			}else {
				System.out.print((py[i]+1));
			}
			
		}
		System.out.println();
		for(int i=0;i<n;i++) {
			if(i<n-1) {
				System.out.print((pz[i]+1)+" ");
			}else {
				System.out.print((pz[i]+1));
			}
			
		}
		System.out.println();

	}

}
