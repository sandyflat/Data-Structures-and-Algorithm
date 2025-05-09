// Print x^N (Stack height=logN)(ie less stack height) using recursion.
package Recursion1;

public class XpowerNOptimized {
    public static int calculatePower(int x, int n){
        if(x==0){          //base case 1
            return 0;
        }
        if(n==0){          // base case 2
            return 1;
        }

        // if n is even
        if(n%2 ==0){
            return calculatePower(x,n/2) * calculatePower(x,n/2);    // both function calls
        }else{   // if n is odd                                            // in same step which
            return calculatePower(x,n/2) * calculatePower(x,n/2) * x; // is more optimized and
        }                                                                   // requires less space
    }
    public static void main(String[] args) {
        int x=2,n=3;
        System.out.println(calculatePower(x,n));
    }
}
