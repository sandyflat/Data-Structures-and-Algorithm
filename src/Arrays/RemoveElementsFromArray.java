package Arrays;

import java.util.Arrays;

public class RemoveElementsFromArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        removeElement(arr, 1);
        System.out.println(Arrays.toString(arr));
    }

    static void removeElement(int[] arr, int index){
        for (int i = index; i<arr.length-1; i++){
            arr[i]= arr[i+1];
        }
        arr[arr.length-1] =0;  // last index will be empty ie 0
    }
}
