import java.util.Arrays;
import java.util.Scanner;

class p1 {
 
  static int[] solution(String A, String B) {
    String[] arr1=A.split(",", 10000);
    String[] arr2=B.split(",", 10000);
    int[] M=new int [arr1.length];
    int[] N=new int [arr2.length];


    for(int i=0; i<arr1.length; i++){
        M[i]=minChar(arr1[i]);
    }
    for(int i=0; i<arr2.length; i++){
        N[i]=minChar(arr2[i]);
    }
    Arrays.sort(M);

    int ans[]=new int[N.length];

    for (int i=0; i<N.length; i++){
        ans[i]=bSearch(M, N[i]-0.1)+1;
    }

    return ans;
  }

    static int bSearch(int arr[], double x) 
    { 
        int l = 0, r = arr.length - 1; 
        while (l <= r) { 
            int m = l + (r - l) / 2; 
            if (arr[m] == x) 
                return m; 
            if (arr[m] < x) 
                l = m + 1; 
            else
                r = m - 1; 
        }
        return r; 
    }

  static int minChar(String A){
      char []arr=A.toCharArray();
      int ans=1;
      char min=arr[0];
      for(int i=1; i< arr.length; i++){
          if(arr[i]<min){
              ans=1;
              min=arr[i];
          }else if(arr[i]==min){
              ans++;
          }
      }
      return ans;
  }
  
  public static void main(String[] args) {
    // Read from stdin, solve the problem, write answer to stdout.
    Scanner in = new Scanner(System.in);
    String A = in.next();
    String B = in.next();
    System.out.print(printIntArray(solution(A, B)));
  }
  
  private static String printIntArray(int[] input) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < input.length; i++) {
      sb.append(input[i]);
      if (i < input.length - 1) {
        sb.append(',');
      }
    }
    return sb.toString();
  }
}