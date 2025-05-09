// Find position of an element in a sorted array of infinite numbers.(ie array is infinite)
// https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
package BinarySearchQuestions;

public class InfiniteArray {
    public static void main(String[] args) {
        int[] arr = {3,5,7,9,10,90,100,130,140,160,170};    // this is infinite array
        System.out.println(answer(arr, 90));          // we cannot use array size as N-1
    }

    // we do reverse process of binary search like going from 1 to up like 1, N/4, N/2, N.
    // this means taking boundary size of searching.
    // and time complexity remains same as O(logN) as like binary search.
    public static int answer(int[] arr, int target){
        // first find the range
        // first start with a box of size 2
        int start = 0;
        int end = 1;

        // condition for the target to lie in the range
        while(target > arr[end]){
            int newStart = end +1; // this is new start
            // double the box value every time
            // end = previous end + sizeofbox *2
            end = end + (end -start +1) *2;
            start = newStart;                  // updating start
        }
        return binarySearch(arr, target, start, end);
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
