package QuickSort;                  // O(n^2)

public class QuickSort {
    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low-1;       // this i tracks the empty space where element smaller than pivot can
                             // be placed
        for(int j= low; j<high; j++){
            if(arr[j] < pivot){
                i++;
                //swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;
        return i;   // pivot index
    }
    public static void quickSort(int[] arr, int low , int high ){
        if(low < high){
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex-1);
            quickSort(arr, pivotIndex+1, high);
        }
    }

    public static void printArray(int[] arr){
        for(int i =0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
         int[] arr = {6,3,9,5,2,8,};
         quickSort(arr, 0, arr.length-1);
         printArray(arr);
    }
}
