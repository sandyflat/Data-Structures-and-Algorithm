// Program to print permutations of string using recursion.    O(n!)
// This is the code/example of backtracking.
package Recursion3;

public class PermutationOfString {
    public static void printPermutation(String str, String permutation){
        if(str.length()==0){
            System.out.println(permutation);
            return;
        }
        for(int i=0; i<str.length(); i++){
            char currChar = str.charAt(i); // selects one character at a time
            String newString = str.substring(0,i) + str.substring(i+1); // forms new string
            printPermutation(newString,permutation+currChar);          // by removing
        }                                                                        // current char
    }
    public static void main(String[] args) {
        printPermutation("abc","");
    }
}
