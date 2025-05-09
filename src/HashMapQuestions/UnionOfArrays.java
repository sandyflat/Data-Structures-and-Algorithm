// program to store union of 2 arrays.
// arr1[] = {7,3,9}
// arr2[] = {6,3,9,2,9,4}
package HashMapQuestions;
import java.util.HashSet;

public class UnionOfArrays {
    public static void unionOfArrays(int[] arr1, int[] arr2){       // O(n)
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<arr1.length; i++){
            set.add(arr1[i]);
        }

        for(int j=0; j<arr2.length; j++){
            set.add(arr2[j]);
        }
        System.out.println(set);
    }
    public static void main(String[] args) {
        int[] arr1 = {7,3,9};
        int[] arr2 = {6,3,9,2,9,4};
        unionOfArrays(arr1, arr2);
    }
}
