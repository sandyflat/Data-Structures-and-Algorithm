package HashMapQuestions;

// Program to store/print intersection of two arrays.

import java.util.ArrayList;
import java.util.HashSet;

public class IntersectionOfArrays {
    public static void intersectionOfArrays(int[] arr1, int[] arr2){
        HashSet<Integer> hashSet = new HashSet<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

      // make elements of at least one array unique to remove duplicate
        for(int i=0; i<arr1.length; i++){
            hashSet.add(arr1[i]);
        }

        // compare hashset elements with elements of second array.
        for(int j = 0; j<arr2.length; j++){
            if(hashSet.contains(arr2[j])){
                arrayList.add(arr2[j]);
                // then remove the element from hashset because it may be
                // redundant in array 2
                hashSet.remove(arr2[j]);
            }
        }
        System.out.println(arrayList);
    }

    public static void main(String[] args) {
        int[] arr1 = {7,3,9};
        int[] arr2 = {6,3,9,2,9,4};
        intersectionOfArrays(arr1, arr2);
    }
}
