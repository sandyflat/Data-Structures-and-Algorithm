// Program to find whether a target value is present in array or not in particular range.
package LinearSearch;

public class SearchInRange {
    public static boolean searchInrange(int[] arr, int target, int starting, int ending){
        for(int i=starting; i<=ending; i++){
            if(arr[i] == target){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {2,4,6,87,34,23,56,34,12,90};
        System.out.println(searchInrange(arr, 23,3,4));
    }
}
