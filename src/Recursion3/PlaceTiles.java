// Program to place the tiles of size 1*m (matrix) in a floor of size n*m (matrix) using recursion.
package Recursion3;

public class PlaceTiles {
    public static int placeTiles(int n, int m){
        if(n==m){         // base case 1
            return 2;
        }
        if (n < m) {      // base case 2
            return 1;
        }
        // vertically
        int vertPlacements = placeTiles(n-m,m);

        // horizontally
        int horiPlacements = placeTiles(n-1,m);
        return vertPlacements + horiPlacements;
    }
    public static void main(String[] args) {
        System.out.println(placeTiles(4,2)); // since size of tiles is fixed ie 1*m.
    }
}
