// Program to count total path in maze (matrix) from (0,0) to (n,m) where n*m is size of matrix.
package Recursion3;

public class CountPath {
    public static int countPaths(int i, int j, int n, int m){
        if(i==n || j==m){    // out of bounds
            return 0;
        }
        if(i==n-1 && j==m-1){    // reached destination
            return 1;
        }

        // move downwards
        int downPaths = countPaths(i+1,j, n, m);

        // move right
        int rightPaths = countPaths(i,j+1,n,m);
        return downPaths + rightPaths;
    }
    public static void main(String[] args) {
        System.out.println(countPaths(0,0,3,3));
    }
}

// Note:
// The path only travel downwards and right to reach the destination.
