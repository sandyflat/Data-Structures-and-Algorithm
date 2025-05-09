// Find floor of target number in an array
// floor = greatest number in an array smaller or equal to target .
// suppose arr= {2,4,6,8,12,23,34,45};
// if target is 12 then answer is 12 but
// if target is 7 then answer is 6 since 7 is not present in array and 7 is greatest smaller
// element than 7.
package BinarySearchQuestions;

public class FloorOfNumber {
    public static void main(String[] args) {
        int[] arr = {6,8,12,23,30,34,45};
        System.out.println(floorOfNumber(arr, 5));
    }
    public static int floorOfNumber(int[] arr, int target){

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
        return end;    // all is same as ceiling of number problem just return end instead
                        // of -1
    }
}
