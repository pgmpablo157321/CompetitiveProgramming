import java.util.Scanner;

class segTree{

   
    public int l, r, val;
    public segTree right=null, left=null;
    public segTree(int []arr, int l, int r){
        this.l=l;
        this.r=r;
        if(l==r){
            this.val=arr[l];
        }else{
            int m=(l+r)/2;
            this.left=new segTree(arr, l, m);
            this.right=new segTree(arr, m+1, r);
            this.val=GCD(left.val, right.val);
        }
    }

    public int query(int a, int b){
        if(a>this.r||b<this.l){
			return 0;
		}else if(a<=this.l&&b>=this.r){
            return this.val;
		}else{
			return GCD(this.right.query(a,b), this.left.query(a, b));
			
		}
    }

    public static int GCD(int a, int b){
        if(a == 0){
            return b;
        }
        int aux=0;
        while(b>0){
            aux=a;
            a=b;
            b=aux%b;
        }
        return a;
    }

}

class P2{


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[]=new int[n];
        for(int i=0; i<n; i++){
            a[i] = in.nextInt();
        }
        int q = in.nextInt();
        segTree t=new segTree(a, 0, n-1);
        for(int i=0; i<q; i++){
            int l=in.nextInt();
            int r=in.nextInt();
            System.out.println(t.query(l, r));
        }
    }
}