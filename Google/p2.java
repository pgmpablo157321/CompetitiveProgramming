import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.stream.Collectors;


class p2{
    
    
    static Integer[] solution(Integer[] N, int K) {
    int MaxIndex=0;
    if(N.length<K)
        return new Integer[0];
    for(int i=1; i<N.length-K+1; i++){
        if(compareIndexes(MaxIndex, i, N, K)){
            MaxIndex=i;
        }
    }
    return Arrays.copyOfRange(N, MaxIndex, MaxIndex+K);
    }
    static boolean compareIndexes(int index1, int index2, Integer[]arr, int K){
        for(int i=0; i<K; i++){
            if(arr[index1+i]<arr[index2+i]){
                return true;
            }
            if(arr[index1+i]>arr[index2+i]){
                return false;
            }
        }
        return false;
    }
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Integer[] N = getIntegerArray(in.next());
    Integer K = Integer.parseInt(in.next());
    System.out.print(fromIntArray(solution(N, K)));
  }

  private static Integer[] getIntegerArray(String str) {
    return Stream.of(str.split("\\,"))
          .map(Integer::valueOf)
          .toArray(Integer[]::new);
  }

  private static String fromIntArray(Integer[] input) {
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