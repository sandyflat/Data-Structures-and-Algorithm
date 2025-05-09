// Find ceiling of target number in an array
// Ceiling = smallest element in an array greater or equal to target .
// suppose arr= {2,4,6,8,12,23,34,45};
// if target is 12 then answer is 12 but
// if target is 7 then answer is 8 since 7 is not present in array and 8 is smallest greater
// element than 7.
package BinarySearchQuestions;

public class CeilingOfNumber {
    public static void main(String[] args) {
        int[] arr = {2,4,6,8,12,23,34,45};
        System.out.println(ceilingOfNumber(arr, 46));
    }
    public static int ceilingOfNumber(int[] arr, int target){
        if(target > arr[arr.length-1]){
            return -1;
        }
        int start = 0;
        int end = arr.length-1;

        while(start <= end){
            int mid = start + (end -start)/2;
            if(target < arr[mid]){
                end = mid-1;
            }else if (target > arr[mid]){
                start = mid +1;
            }else{
                return mid;
            }
        }
        return start;    // all is same as normal binary search just return start instead
                         // of -1
    }
}
