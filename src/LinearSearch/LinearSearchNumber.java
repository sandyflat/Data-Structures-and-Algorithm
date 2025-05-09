// Program to find whether the target number is in array or not using linear search. O(n)
package LinearSearch;

public class LinearSearchNumber {
    public static int linearSearch(int[] arr, int target){
        for(int i=0; i<arr.length; i++){              // method 1
            if(arr[i] == target){
                return i;
            }
        }
//        for(int num: arr){                          // method 2 using for each loop.
//            if(num == target){
//                return num;
//            }
//        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2,5,7,3,45,12,67,43};
        System.out.println(linearSearch(arr, 45));
    }
}
