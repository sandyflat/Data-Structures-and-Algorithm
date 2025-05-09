// LeetCode 852. Peak Index in a Mountain Array/ bitonic array.
// https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
package BinarySearchQuestions;

public class LeetCode852 {
    public static void main(String[] args) {
      int[] arr = {2,4,6,8,7,5,3,1};
        System.out.println(peakIndexInMountainArray(arr));
    }

    public static int peakIndexInMountainArray(int[] arr){
        int start = 0;
        int end = arr.length-1;

        while(start < end){
            int mid = start + (end -start)/2;
            if(arr[mid] > arr[mid +1]){
                // we are in descending part of array
                // this may be the ans, but look at left part
                end = mid;    // this is why end != mid-1
            }else{
                // we are in ascending part of array
                start = mid +1; // because we know that mid +1 element > mid element
            }
        }
        // in the end, start == end and pointing to the largest/peak number.
        // start and end are always trying to find max element in the above 2 checks.
        // hence, when they are pointing to just one element, that is the max one because
        // that is what the checks say.
        // more elaboration: at every point of time for start and end, they have the best possible
        // answer till that time.

        return start; // or return end as both are equal.
    }
}
