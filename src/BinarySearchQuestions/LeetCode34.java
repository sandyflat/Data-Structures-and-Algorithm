// LeetCode 34. Find the first and last position of element in sorted Array.
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
package BinarySearchQuestions;

import java.util.Arrays;

public class LeetCode34 {
    public static void main(String[] args) {
       int[] nums = {5,7,7,8,8,10};
       System.out.println(Arrays.toString(searchRange(nums,8)));
    }

    public static int[] searchRange(int[] nums, int target){
        int[] ans = {-1,-1}; // final answer to be returned if answer isn't found

        int start = search(nums, target, true);  // want to find first index
        int end = search(nums, target, false);   // want to find last index

        ans[0] = start;
        ans[1] = end;
        return ans;
    }

    // this function just returns the index value of target
   public static int search(int[] nums, int target, boolean findStartIndex){
        int ans = -1;      // potential answer initially.
        int start = 0;
        int end = nums.length-1;

        while (start <= end) {
            // find the middle element
            int mid = start + (end - start)/2;

            if(target < nums[mid]){
                end = mid-1;
            }else if(target > nums[mid]){
                start = mid +1;
            }else {
                // potential ans found
                ans = mid;
                if(findStartIndex){      // check for first index
                    end = mid-1;
                }else {                  // check for last index
                    start = mid +1;
                }
            }
        }
      return ans;
    }
}
