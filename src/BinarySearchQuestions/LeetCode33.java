// LeetCode 33. Search in Rotated sorted array.
// https://leetcode.com/problems/search-in-rotated-sorted-array/description/
package BinarySearchQuestions;

public class LeetCode33 {
    public static void main(String[] args) {
       int[] arr = {4,5,6,7,0,1,2};
        System.out.println(findPivot(arr));
        System.out.println(search(arr,6));
    }

    public static int search(int[] arr, int target){
        int pivot = findPivot(arr);

        // if we didn't find a pivot, it means the array is not rotated.
        if(pivot == -1){
            // just do normal binary search
            return binarySearch(arr, target,0, arr.length-1);
        }

        // if pivot is found, we have found 2 ascending sorted arrays.
        // Case 1:
        if(arr[pivot] == target){
            return pivot;
        }
        // Case 2:
        if(target >= arr[0]){
            return binarySearch(arr, target,0, pivot-1);
        }
        return binarySearch(arr, target, pivot +1, arr.length-1);
    }

    // this will not perform for duplicate elements.
    public static int findPivot(int[] arr){   // note: pivot element is largest element
        int start = 0;                        // in an array.
        int end = arr.length-1;

        while(start <= end){
            int mid = start + (end - start)/2;
            // now write the possible cases:
            // Case 1:
            if(mid < end && arr[mid] > arr[mid+1]){
                // found the answer. mid will be pivot element index.
                return mid;
            }
            // Case 2:
            if(mid > start && arr[mid] < arr[mid-1]){
                // mid -1 will be pivot element index.
                return mid-1;
            }
            // Case 3:
            if(arr[mid] <= arr[start]){
                end = mid -1;     // then no need to consider arrays right from mid
            }else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target, int start, int end){

        while (start <= end) {
            // find the middle element
            int mid = start + (end - start)/2;

            if(target < arr[mid]){
                end = mid-1;
            }else if(target > arr[mid]){
                start = mid +1;
            }else {
                // ans found
                return mid;
            }
        }
        return -1;
    }
}
