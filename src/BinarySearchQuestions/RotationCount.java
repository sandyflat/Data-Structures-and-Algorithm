// Find the Rotation Count in Rotated Sorted array.
// https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/
package BinarySearchQuestions;

public class RotationCount {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(countRotations(arr) + " times");
    }

    private static int countRotations(int[] arr){
        int pivot = findPivot(arr);
        return pivot +1;
    }

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

}
