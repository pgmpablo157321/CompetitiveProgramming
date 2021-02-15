import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

class p2{


    public static boolean contains(int arr[], int t){
        for(int i=0; i<t; i++){
            if(arr[i]==t){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=1;i<=t; i++){
            int a[]=new int[5];
            Queue m=new LinkedList<Integer>();
            Queue q1=new LinkedList<Integer>();
            Queue q2=new LinkedList<Integer>();
            Queue q3=new LinkedList<Integer>();
            Queue q4=new LinkedList<Integer>();
            Queue q5=new LinkedList<Integer>();
            int F=in.nextInt();
            for(int j=0; j<119; j++){
                System.out.println(5*j+1);
                String act=in.next();
                if(act.equals("A")){
                    q1.add(5*j+1);
                }
                if(act.equals("B")){
                    q2.add(5*j+1);
                }
                if(act.equals("C")){
                    q3.add(5*j+1);
                }
                if(act.equals("D")){
                    q4.add(5*j+1);
                }
                if(act.equals("E")){
                    q5.add(5*j+1);
                }
            }
            if(q1.size()==23){
                while(!q1.isEmpty()){
                    m.add(q1.poll());
                }
                a[0]=1;
            }
            if(q2.size()==23){
                while(!q2.isEmpty()){
                    m.add(q2.poll());
                }
                a[0]=2;
            }
            if(q3.size()==23){
                while(!q3.isEmpty()){
                    m.add(q3.poll());
                }
                a[0]=3;
            }
            if(q4.size()==23){
                while(!q4.isEmpty()){
                    m.add(q4.poll());
                }
                a[0]=4;
            }
            if(q5.size()==23){
                while(!q5.isEmpty()){
                    m.add(q5.poll());
                }
                a[0]=5;
            }

            q1=new LinkedList<Integer>();
            q2=new LinkedList<Integer>();
            q3=new LinkedList<Integer>();
            q4=new LinkedList<Integer>();
            q5=new LinkedList<Integer>();

            while(!m.isEmpty()){
                int x=(int)m.poll();
                System.out.println(x+1);
                String act=in.next();
                if(act.equals("A")){
                    q1.add(x+1);
                }
                if(act.equals("B")){
                    q2.add(x+1);
                }
                if(act.equals("C")){
                    q3.add(x+1);
                }
                if(act.equals("D")){
                    q4.add(x+1);
                }
                if(act.equals("E")){
                    q5.add(x+1);
                }
            }

            if(q1.size()==5){
                while(!q1.isEmpty()){
                    m.add(q1.poll());
                }
                a[1]=1;
            }
            if(q2.size()==5){
                while(!q2.isEmpty()){
                    m.add(q2.poll());
                }
                a[1]=2;
            }
            if(q3.size()==5){
                while(!q3.isEmpty()){
                    m.add(q3.poll());
                }
                a[1]=3;
            }
            if(q4.size()==5){
                while(!q4.isEmpty()){
                    m.add(q4.poll());
                }
                a[1]=4;
            }
            if(q5.size()==5){
                while(!q5.isEmpty()){
                    m.add(q5.poll());
                }
                a[1]=5;
            }
            q1=new LinkedList<Integer>();
            q2=new LinkedList<Integer>();
            q3=new LinkedList<Integer>();
            q4=new LinkedList<Integer>();
            q5=new LinkedList<Integer>();

            while(!m.isEmpty()){
                int x=(int)m.poll();
                System.out.println(x+1);
                String act=in.next();
                if(act.equals("A")){
                    q1.add(x+1);
                }
                if(act.equals("B")){
                    q2.add(x+1);
                }
                if(act.equals("C")){
                    q3.add(x+1);
                }
                if(act.equals("D")){
                    q4.add(x+1);
                }
                if(act.equals("E")){
                    q5.add(x+1);
                }
            }

            if(q1.size()==1){
                while(!q1.isEmpty()){
                    m.add(q1.poll());
                }
                a[2]=1;
            }
            if(q2.size()==1){
                while(!q2.isEmpty()){
                    m.add(q2.poll());
                }
                a[2]=2;
            }
            if(q3.size()==1){
                while(!q3.isEmpty()){
                    m.add(q3.poll());
                }
                a[2]=3;
            }
            if(q4.size()==1){
                while(!q4.isEmpty()){
                    m.add(q4.poll());
                }
                a[2]=4;
            }
            if(q5.size()==1){
                while(!q5.isEmpty()){
                    m.add(q5.poll());
                }
                a[2]=5;
            }
            q1=new LinkedList<Integer>();
            q2=new LinkedList<Integer>();
            q3=new LinkedList<Integer>();
            q4=new LinkedList<Integer>();
            q5=new LinkedList<Integer>();

            while(!m.isEmpty()){
                int x=(int)m.poll();
                System.out.println(x+1);
                String act=in.next();
                if(act.equals("A")){
                    q1.add(x+1);
                }
                if(act.equals("B")){
                    q2.add(x+1);
                }
                if(act.equals("C")){
                    q3.add(x+1);
                }
                if(act.equals("D")){
                    q4.add(x+1);
                }
                if(act.equals("E")){
                    q5.add(x+1);
                }
            }

            if(q1.size()==0 && !contains(a, 1)){
                while(!q1.isEmpty()){
                    m.add(q1.poll());
                }
                a[3]=1;
            }
            if(q2.size()==1  && !contains(a, 2)){
                while(!q2.isEmpty()){
                    m.add(q2.poll());
                }
                a[3]=2;
            }
            if(q3.size()==1 && !contains(a, 3)){
                while(!q3.isEmpty() ){
                    m.add(q3.poll());
                }
                a[3]=3;
            }
            if(q4.size()==1&& !contains(a, 4)){
                while(!q4.isEmpty() ){
                    m.add(q4.poll());
                }
                a[3]=4;
            }
            if(q5.size()==1&& !contains(a, 5)){
                while(!q5.isEmpty() ){
                    m.add(q5.poll());
                }
                a[3]=5;
            }

            q1=new LinkedList<Integer>();
            q2=new LinkedList<Integer>();
            q3=new LinkedList<Integer>();
            q4=new LinkedList<Integer>();
            q5=new LinkedList<Integer>();

            for(int j=1; j<=5; j++){
                if(!contains(a, j)){
                    a[4]=i;
                }
            }
            String ans="";
            for(int j=0; j<5; j++){
                switch(a[j]){
                    case 1:
                        ans+="A";
                    break;
                    case 2:
                        ans+="B";
                    break;
                    case 3:
                        ans+="C";
                    break;
                    case 4:
                        ans+="D";
                    break;
                    case 5:
                        ans+="E";
                    break;
                }
                
            }
            
            System.out.println("Case #"+i+": "+ans);
            if(in.next()=="N"){
                i=t+1;
            }
            
        }
    }
}