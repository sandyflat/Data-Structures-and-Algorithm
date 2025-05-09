// Program to print sum of n natural numbers using recursion.
package Recursion1;

public class NaturalNumbers {
    public static void printSum(int i, int n, int sum){
        if(i==n){
            sum+=i;
            System.out.println(sum);
            return;
        }
        sum+=i;
        printSum(i+1,n,sum);
        System.out.println(i);  // this line is printed at last cause each function call
                                // in stack return to previous step one by one
    }
    public static void main(String[] args) {
        int n=5;
        int starting =1;
        printSum(starting,n,0);
    }
}

