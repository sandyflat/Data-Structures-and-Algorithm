// Program to print factorial number n using recursion.
package Recursion1;

public class Factorial {
    public static int calculateFactorial(int n){
        if(n==1 || n==0){
            return 1;
        }
        return n*calculateFactorial(n-1);
    }

    public static void main(String[] args) {
        int n=5;
        System.out.println(calculateFactorial(n));
    }
}
