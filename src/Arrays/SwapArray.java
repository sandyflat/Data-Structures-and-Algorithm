package Arrays;
import java.util.Arrays;

// program to swap values of an index of an array
public class SwapArray {
    public static void main(String[] args) {
        int[] arr= {2,4,6,9,4};
        swap(arr,1,3);                     // when array is passed as argument in any method
        System.out.println(Arrays.toString(arr));       // then its original copy is passed so array is
    }                                                   // changed after swap method
    public static void swap(int[] arr,int index1,int index2){
        int temp= arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=temp;
    }
}
