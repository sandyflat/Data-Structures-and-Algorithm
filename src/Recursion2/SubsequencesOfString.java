// Program to print subsequences of string using recursion.(important) O(2^n)
package Recursion2;

public class SubsequencesOfString {
    public static void subsequences(String str, int index, String newString){
        if(index==str.length()){
            System.out.println(newString);
            return;
        }
        char currChar = str.charAt(index);
        // want to be
         subsequences(str,index+1,newString+currChar);
        // don't want to be
         subsequences(str,index+1,newString);
    }
    public static void main(String[] args) {
       subsequences("abc",0,"");
    }
}

// Note
// A subsequence of a string is a new string that is derived
// from the original string by deleting zero or more characters
// without changing the relative order of the remaining characters.
// for string "abc" , the subsequences are
// abc, ab, ac, a, bc, b, c, _
