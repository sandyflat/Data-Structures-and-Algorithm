// Print x^n (Stack height=n) using recursion.
package Recursion1;

public class XpowerN {
    public static int calculatePower(int x, int n){
        if(x==0){          //base case 1
            return 0;
        }
        if(n==0){          // base case 2
            return 1;
        }
        return x*calculatePower(x,n-1);
    }
    public static void main(String[] args) {
        int x=2,n=3;
        System.out.println(calculatePower(x,n));
    }
}
