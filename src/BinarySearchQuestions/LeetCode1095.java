// LeetCode 1095. Find in the Mountain array.
// https://leetcode.com/problems/find-in-mountain-array/description/
package BinarySearchQuestions;

public class LeetCode1095 {
    public static void main(String[] args) {
       int[] arr = {1,2,3,4,5,3,1};
        System.out.println(search(arr, 3));
    }

    public static int search(int[] arr, int target){
        int peak = peakIndexInMountainArray(arr);
        int firstTry = orderAgnosticsBS(arr, target, 0, peak);
        if(firstTry != -1){
            return firstTry;
        }
        // try to search in second half of array
        return orderAgnosticsBS(arr, target,peak +1, arr.length-1);
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

    public static int orderAgnosticsBS(int[] arr, int target, int start, int end){

        // find whether the array is sorted in ascending or descending
        boolean isAsc = arr[start] < arr[end];

        while(start <=end){
            // find the middle element
            int mid = start + (end-start)/2;

            if(arr[mid] ==target){
                return mid;
            }

            if(isAsc){                  // for ascending sorted array
                if(target < arr[mid]){
                    end = mid -1;
                }else{
                    start = mid +1;
                }
            }else {                     // for descending sorted array
                if(target > arr[mid]){
                    end = mid -1;
                }else {
                    start = mid +1;
                }
            }
        }
        return -1;
    }
}
