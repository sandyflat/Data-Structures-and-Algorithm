package Arrays;

// Program to print sub arrays of an array.  O(n^3).
// Sub array is the sequence of contineous element of any array.
// it is different from subsets.

public class SubArrays {
    public static void printSubArrays(int[] arr){
        for(int i = 0; i<arr.length; i++){
            for(int j = i; j<arr.length; j++){
                for(int k=i; k<=j; k++){
                    System.out.print(arr[k] +"\t");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        printSubArrays(arr);
    }
}
