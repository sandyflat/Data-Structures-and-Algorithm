package Arrays;
import java.util.Arrays;
// Program to reverse array
public class ReverseArray {
    public static void main(String[] args) {
        int[] arr= {1,2,3,4,5};
        reverseArray(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void reverseArray(int[] arr){
        int start=0;
        int end=arr.length-1;
        while(start<end){
            int temp=arr[start];       // swap(arr,start,end);
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
}
// we can also use swap method
// static void swap(int[] arr, int start, int end){
//   int temp= arr[start];
//    arr[start]= arr[end];
//     arr[end] = temp;
