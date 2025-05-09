// https://leetcode.com/problems/two-sum/description/
// Two Sum
// Approach using Hashmap
package ArraysLeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class LeetCode1 {
    public static void main(String[] args) {
        int[] arr = {3,2,5,8};
        int target = 7;
        int[] result = twoSum(arr, target);
        System.out.println(Arrays.toString(result));
    }

    // Using HashMap ( optimized approach) O(n)
    private static int[] twoSum(int[] arr, int target){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            int diff = target - arr[i];

            if(map.containsKey(diff)){
                return new int[] {map.get(diff), i};
            }
            map.put(arr[i], i);
        }
        return new int[] {};
    }
}
