import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

class CryptoPan{
    public static int gcd(int a, int b){
        int aux=0;
        while(b>0){
            aux=a;
            a=b;
            b=aux%b;
        }
        return a;
    }
    public static boolean contains(int list[], int target){
        for(int i=0; i<list.length;i++){
            if(list[i]==target){
                return true;
            }
            
        }
        return false;
    }

    public static int indice(int list[], int target){
        for(int i=0; i<list.length;i++){
            if(list[i]==target){
                return i;
            } 
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0; i<t; i++){
            int n=in.nextInt();
            int l=in.nextInt();
            int a[]=new int[l];
            for(int j=0; j<l; j++){
                a[j]=in.nextInt();
            }
            int index=0, primo=0;
            while(primo==0){
                if(a[index]!=a[index+1]){
                    primo=gcd(a[index], a[index+1]);
                }
                index++;
            }
            
            int aux=primo, aux2=1;
            int list[]=new int[26];
            
            list[0]=primo;
            int list2[]=new int[l+1];
            list2[index]=primo;
            int target=0;
            for(int j=index; j<l;j++){
                target=a[j]/aux;
                list2[j+1]=target;
                if(!contains(list, target)){
                    list[aux2]=target;
                    aux2++;   
                }
                aux=target;
                
            }
            
            
            aux=primo;
            for(int j=index-1; j>=0;j--){
                target=a[j]/aux;
                list2[j]=target;
                if(!contains(list, target)){
                    list[aux2]=target;
                    aux2++;
                }
                aux=target;
            }
            Arrays.sort(list);
            System.out.println("Case #"+(i+1)+": ");
            for(int j=0; j<list2.length; j++){
                char c=(char)(indice(list, list2[j])+65);
                System.out.print(c);
            }
            System.out.println();
        }

    }


}