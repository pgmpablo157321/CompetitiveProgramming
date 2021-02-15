import java.util.Scanner;
import java.util.*;


class metodos {
    public void divisores(int n){
        int suma=0;
        int num=0;
        for(int i=1; i<=n; i++){
            if(n%i==0){
                suma=suma+i;
                num++;
            }
        }
        System.out.println("El numero de divisores es: "+num);
        System.out.println("La suma de divisores es: "+suma);
    }

    public void sumaPrimos(int n){
        int cont=0;
        int act=2;
        int suma=0;
        while(cont<n){
            boolean esPrimo=true;
            for(int i=2; i<act; i++){
                if(act%i==0){
                    esPrimo=false;
                }
            }
            if(esPrimo){
                suma=suma+act;
                System.out.println(act);
                cont++;
            }
            act++;
        }
        System.out.println("la suma de los primos es: "+suma);
    }
    public static void main(String[] args) {
        metodos m=new metodos();
        //m.divisores(8191);
        m.sumaPrimos(100);
    }

}