// Find the target element using Binary Search. O(logN)
package BinarySearch;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;

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

    public static void main(String[] args) {
         int[] arr = {-23,-12,2,3,5,7,8,23};
        System.out.println(binarySearch(arr,8));
    }
}
