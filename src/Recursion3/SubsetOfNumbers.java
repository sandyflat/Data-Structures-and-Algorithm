// Program to print all the subsets of set of n natural numbers using recursion. O(2^n)
package Recursion3;
import java.util.ArrayList;

public class SubsetOfNumbers {
    public static void printSubsets(ArrayList<Integer> subset){
        for(int i=0; i<subset.size(); i++){
            System.out.print(subset.get(i) +" ");
        }
        System.out.println();
    }
    public static void findSubsets(int n, ArrayList<Integer> subset){
        if(n==0){
            printSubsets(subset);
            return;
        }

        // element added
        subset.add(n);
        findSubsets(n-1,subset);

        // element don't added
        subset.remove(subset.size()-1);
        findSubsets(n-1,subset);
    }
    public static void main(String[] args) {
        ArrayList<Integer> subset = new ArrayList<>();
        findSubsets(3,subset);
    }
}
