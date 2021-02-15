import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;

class GMEDIAN {


    public static int solve(int[]a, int n){
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            if(m.get(target-nums[i]) !=  null){

                int[]ans=new int[2];
                ans[0]=m.get(target-nums[i]);
                ans[1]=i;
                return ans;
            }
            m.put(nums[i], i);
        }
        return null;
    }


    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0; i<t; i++){
            int n=in.nextInt();
            int a[]=new int[n];
            for(int j=0; j<n; j++){
                a[j]=in.nextInt();
            }
            Arrays.sort(a);
            System.out.println(solve(a, n));
        }
        
        
    }
}