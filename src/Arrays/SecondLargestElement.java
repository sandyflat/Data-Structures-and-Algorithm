// Find 2nd largest element in an array.
package Arrays;

public class SecondLargestElement {
    public static void main(String[] args) {
        int[] arr = {12,8,50,20,9,2};
        System.out.println(findSecondLargest(arr));
    }

    private static int findSecondLargest(int[] arr){
        int max1 = 0;
        int max2 = 0;

        if(arr[0] > arr[1]){
            max1 = arr[0];
            max2 = arr[1];
        }else{
            max1 = arr[1];
            max2 = arr[0];
        }

        for(int i = 1; i< arr.length; i++){
            if(arr[i] > max1){
                max1 = arr[i];
            }else if(arr[i] > max2){
                max2 = arr[i];
            }
        }
        return max2;
    }
}
