// Program to check if an array is sorted (Strictly increasing) ie 12344 (wrong) O(n)
package Recursion2;                                              //12345 (right)

public class CheckSorted {
   public static boolean isSorted(int[] arr, int index){
       if(index==arr.length-1){
           return true;
       }
       if(arr[index]<arr[index+1]){
           // array is sorted till now
         return isSorted(arr,index+1);   // function returns value to previous function
       }else{
           return false;
       }
   }

    public static void main(String[] args) {
        int[] arr={1,3,3,5,7};
        System.out.println(isSorted(arr,0));
    }
}
