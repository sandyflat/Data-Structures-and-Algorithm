// Program to print only unique subsequences of a string using recursion.
package Recursion2;
import java.util.HashSet;

public class UniqueSubsequences {
    public static void subsequences(String str, int index, String newString, HashSet<String> set){
        if(index==str.length()){
           if(set.contains(newString)){
               return;
           }else{
               System.out.println(newString);
               set.add(newString);
               return;
           }
        }
        char currChar = str.charAt(index);
        // want to be
        subsequences(str,index+1,newString+currChar,set);
        // don't want to be
        subsequences(str,index+1,newString,set);
    }
    public static void main(String[] args) {
      String str= "aaa";
        HashSet<String> set = new HashSet<>();
        subsequences(str,0,"",set);
    }
}

// Note
//a HashSet is a part of the java.util package and
// is a collection that uses a hash table for storing elements.
// A HashSet does not allow duplicate elements.
// If we try to add a duplicate, it will be ignored.
// Elements are not stored in the order in which they are inserted.
// The order depends on the hash codes of the elements.
