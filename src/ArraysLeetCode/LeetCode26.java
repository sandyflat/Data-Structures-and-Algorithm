// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
// Removes Duplicates from Sorted Array.
// Using two pointer approach.
package ArraysLeetCode;

public class LeetCode26 {
    public static void main(String[] args) {
       int[] arr ={1,1,2,3,3,4,4};
       int newSize = removeDuplicates(arr);
       System.out.println("Total unique elements: " + newSize);
        System.out.print("Array after removing duplicates: ");
        for(int i = 0; i < newSize; i++){
            System.out.print(arr[i] + " ");
        }
    }
    static int removeDuplicates(int[] arr){
        int k = 1;      // second pointer/ slow pointer
        for(int i = 1; i<arr.length; i++){
            if(arr[i] != arr[i-1]){
                arr[k] = arr[i];
                k = k+1;
            }
        }
        return k;
    }
}
