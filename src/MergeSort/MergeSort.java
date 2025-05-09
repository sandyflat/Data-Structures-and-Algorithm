// This uses divide and conquer approach
package MergeSort;

public class MergeSort {
    public static void conquer(int[] arr, int startingIndex, int midIndex, int endingIndex){
        int[] mergedArray = new int[endingIndex-startingIndex +1];

        int index1 = startingIndex;    // it tracks 1st array
        int index2 = midIndex + 1;     // it tracks 2nd array
        int x = 0;                     // it tracks mergedArray

        while(index1 <= midIndex && index2 <= endingIndex){
            if(arr[index1] <= arr[index2]){
                mergedArray[x++] = arr[index1++];
            }else{
                mergedArray[x++] = arr[index2++];
            }
        }

        while(index1 <= midIndex){                // if there is left element in 1st array then put
            mergedArray[x++] = arr[index1++];     // them in mergedArray as it is because they are
        }                                         // already sorted.

        while(index2 <= endingIndex){            //if there is left element in 2nd array then put
            mergedArray[x++] = arr[index2++];     // them in mergedArray as it is because they are
        }                                         // already sorted.

        for(int i=0, j= startingIndex; i<mergedArray.length; i++, j++){
            arr[j] = mergedArray[i];
        }
    }
    public static void divide(int[] arr, int startingIndex, int endingIndex){
        if(startingIndex >= endingIndex){
            return;
        }
        int midIndex = startingIndex +(endingIndex-startingIndex)/2;  // this helps to reduce space
        divide(arr, startingIndex,midIndex);                          // complexity, we can also do
        divide(arr, midIndex+1, endingIndex);              // (ending+starting)/2
        conquer(arr, startingIndex, midIndex, endingIndex);
    }

    public static void printArray(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] +" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {6,3,9,5,2,8};
        divide(arr, 0,arr.length-1);
        printArray(arr);
    }
}
