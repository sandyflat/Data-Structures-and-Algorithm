// Program to search element in 2D array using linear search.
package LinearSearch;

import java.util.Arrays;

public class SearchIn2DArray {
    public static int[] searchIn2DArray(int[][] arr, int target){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                if(arr[i][j] == target){
                    return new int[]{i,j};          // return values as an array.
                }
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[][] arr ={{34,2,3,45,76},{78,54,12,67,45}};
        int[] answer = searchIn2DArray(arr,45);      // catch values as an array.
        System.out.println(Arrays.toString(answer));
    }
}
