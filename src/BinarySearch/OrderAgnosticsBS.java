// In this scenario we don't know whether the array is sorted in ascending or descending.
package BinarySearch;

public class OrderAgnosticsBS {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,34,56};
        System.out.println(orderAgnosticsBS(arr, 7));
    }

    public static int orderAgnosticsBS(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;

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
