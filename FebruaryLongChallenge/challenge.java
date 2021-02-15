import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


class challenge {




    public static int value(char a){
        if(a<97){
            return (int)(a-64+26);
        }else{
            return (int)(a-96);
        }
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        Queue <String> ans=new LinkedList<String>();
        int n=in.nextInt();
        int m=in.nextInt();
        int a=in.nextInt();
        int x=in.nextInt();
        int r=in.nextInt();
        int ops=0;
        String S=in.next();
        Stack <Character> st=new Stack<Character>();
        char[]aux=S.toCharArray();
        for(int i=0;i<aux.length; i++){
            st.push(aux[i]);
        }
        int []c=new int[m];
        String []t=new String[m];
        int q[]=new int[a];
        String []p=new String[a];
        for(int i=0; i<m; i++){
            t[i]=in.next();
            c[i]=in.nextInt();
        }
        for(int i=0; i<a;i++){
            p[i]=in.next();
            q[i]=in.nextInt();
        }
        if(x>r){
            double min=Integer.MAX_VALUE;
            int indexMin=0;
            for(int i=0; i<a; i++){
                if((p[i].length()>1)&&(double)q[i]/(p[i].length()-1)<min){
                    min=(double)q[i]/p[i].length();
                    indexMin=i;
                }
            }
            double max=(double)c[0]/(t[0].length()+1);
            int indexMax=0;
            for(int i=0; i<m; i++){
                if((double)c[i]/t[i].length()>max){
                    max=(double)c[i]/(t[i].length()+1);
                    indexMax=i;
                }
            }
            char[]ax=p[indexMin].toCharArray();
            while(x>r+st.size()*30 && st.size()<500000-ax.length && ops < 100000-st.size()-1){
                ans.add(("2 "+st.size()+" "+st.size()+" "+(indexMin+1)));
                x-=q[indexMin];
                ops++;
                st.pop();
                for(int i=0; i<ax.length;i++){
                    st.push(ax[i]);
                }
            }
            char[] st2=new char[st.size()];
            for(int i=st2.length-1; i>=0; i--){
                st2[i]=st.pop();
            }
            char[]ay=t[indexMax].toCharArray();
            ay=Arrays.copyOf(ay, ay.length+1);
            ay[ay.length-1]='-';
            int aux1=1;
            
            while(aux1<=st2.length && (ay[(aux1-1)%ay.length]=='-' || x>=r+Math.abs(value(st2[aux1-1])-value(ay[(aux1-1)%ay.length]))) && ops < 99999){
                if(ay[(aux1-1)%ay.length]!='-' && st2[aux1-1]!=ay[(aux1-1)%ay.length]){
                    ans.add(("1 "+aux1+" "+ay[(aux1-1)%ay.length]));
                    x-=Math.abs(value(st2[aux1-1])-value(ay[(aux1-1)%ay.length]));
                    ops++;
                }
                aux1++;
            }
            ops++;
            ans.add(("3 1 "+st2.length));
            System.out.println(ops);
            while(!ans.isEmpty()){
                System.out.println(ans.poll());
            }
        }else{
            double min=Integer.MAX_VALUE;
            int indexMin=0;
            for(int i=0; i<a; i++){
                if((p[i].length()>1)&&(double)q[i]/(p[i].length()-1)<min){
                    min=(double)q[i]/p[i].length();
                    indexMin=i;
                }
            }
            double max=(double)c[0]/(t[0].length()+1);
            int indexMax=0;
            for(int i=0; i<m; i++){
                if((double)c[i]/t[i].length()>max){
                    max=(double)c[i]/(t[i].length()+1);
                    indexMax=i;
                }
            }
            char[]ax=p[indexMin].toCharArray();
            while(x>st.size()*30 && st.size()<1000000-ax.length && ops < 100000-st.size()){
                ans.add(("2 "+st.size()+" "+st.size()+" "+(indexMin-1)));
                x-=q[indexMin];
                ops++;
                st.pop();
                for(int i=0; i<ax.length;i++){
                    st.push(ax[i]);
                }
            }
            char[] st2=new char[st.size()];
            for(int i=st2.length-1; i>=0; i--){
                st2[i]=st.pop();
            }
            char[]ay=t[indexMax].toCharArray();
            ay=Arrays.copyOf(ay, ay.length+1);
            ay[ay.length-1]='-';
            int aux1=1;
            while(aux1<=st2.length && (ay[(aux1-1)%ay.length]=='-' || x>=Math.abs(value(st2[aux1-1])-value(ay[(aux1-1)%ay.length]))) && ops < 99999){
                if(ay[(aux1-1)%ay.length]!='-' && st2[aux1-1]!=ay[(aux1-1)%ay.length]){
                    ans.add(("1 "+aux1+" "+ay[(aux1-1)%ay.length]));
                    x-=Math.abs(value(st2[aux1-1])-value(ay[(aux1-1)%ay.length]));
                    ops++;
                }
                aux1++;
            }
            
            System.out.println(ops);
            while(!ans.isEmpty()){
                System.out.println(ans.poll());
            }

        }


    }
}