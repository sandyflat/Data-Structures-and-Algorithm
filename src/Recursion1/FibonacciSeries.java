// Program to print fibonacci sequence till nth term using recursion.
package Recursion1;

public class FibonacciSeries {
    public static void printFibonacci(int a, int b, int n){
        if(n==0){
            return;
        }
        int c = a+b;
        System.out.print(c +" ");
        printFibonacci(b,c,n-1);
    }
    public static void main(String[] args) {
        int a = 0, b = 1,n = 10;
        System.out.print(a +" ");
        System.out.print(b +" ");
        printFibonacci(a,b,n-2);
    }
}
