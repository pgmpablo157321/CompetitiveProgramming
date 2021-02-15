import java.util.Scanner;


class P1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0; i<t; i++){
            boolean []v=new boolean[26];
            for(int j=0; j<26; j++){
                v[j]=true;
            }
            int n=in.nextInt();
            for(int j=0;j<n; j++){
                boolean []c=new boolean[26];
                String s=in.next();
                char[]x=s.toCharArray();
                for(int k=0; k<x.length; k++){
                    c[x[k]-97]=true;
                }
                for(int k=0; k<26; k++){
                    v[k]=v[k]&c[k];
                }
            }
            int ans=0;
            for(int j=0; j<26; j++){
                if(v[j]){
                    ans++;
                }
            }
            System.out.println(ans);
        }

    }

}
