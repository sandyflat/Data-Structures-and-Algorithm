// https://leetcode.com/problems/move-zeroes/description/
// Move all zeros to end.
package ArraysLeetCode;

import java.util.Arrays;

public class LeetCode283 {
    public static void main(String[] args) {
        int[] arr = {0,1,0,2,4,0,5};
        moveZeros(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void moveZeros(int[] arr){
        int secondPointer = 0;
        for(int i = 0 ; i < arr.length; i++){
            if(arr[i] != 0){
                arr[secondPointer] = arr[i];
                secondPointer ++;
            }
        }
        for(int j = secondPointer; j<arr.length; j++){
            arr[j] = 0;
        }
    }
}
