import java.util.Arrays;
import java.util.Scanner;

class P7 {

    public static int dist(int x, int y){
        int a[]=new int[4];
        int b[]=new int[4];
        for(int i=0; i<4; i++){
            a[i]=x%10;
            x/=10;
        }

        for(int i=0; i<4; i++){
            b[i]=y%10;
            y/=10;
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int ans=Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1])+Math.abs(a[2]-b[2])+Math.abs(a[3]-b[3]);

        return ans;
    }

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	
		int t = in.nextInt();
		for (int i=0; i<t; i++) {
            int l=in.nextInt();
            int r=in.nextInt();
            int ans=0;
            int mod=1000000007;
            for(int k=l; k<=r; k++){
                for(int j=l; j<=r; j++){
                    ans+=dist(k,j);
                }
                ans%=mod;
            }
            System.out.println(ans);
		}

	}

}
