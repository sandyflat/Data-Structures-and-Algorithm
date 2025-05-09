// https://leetcode.com/problems/contains-duplicate/description/
// Check if Array contains duplicate.
// Approach 1 using Hashset ( best and optimum method)
// Approach 2 using Sorting
package ArraysLeetCode;

import java.util.HashSet;

public class LeetCode217 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        System.out.println(checkDuplicate(arr));
    }

    // using Hashset approach
    private static boolean checkDuplicate(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            if (set.contains(num)) {
                return true;     // duplicate found
            }
            set.add(num);
        }
        return false;
    }
}

//// By sorting the array.
//static boolean checkDuplicate(int[] arr) {
//    Arrays.sort(arr);
//
//    for(int i = 1; i<arr.length; i++){
//        if(arr[i] == arr[i-1]){
//            return true;
//        }
//    }
//    return false;
//}