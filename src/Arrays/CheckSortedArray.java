// Check whether Array is sorted or not.
package Arrays;

public class CheckSortedArray {
    public static void main(String[] args) {
        int[] arr = {4,6,6,8,9};
        System.out.println(checkSorted(arr));
    }

    static boolean checkSorted(int[] arr){
        for(int i = 1; i<arr.length; i++){
            if(arr[i] < arr[i-1]){
                return false;
            }
        }
        return true;
    }
}

