// Program to remove duplicates in a string using recursion. O(n)
package Recursion2;

public class RemoveDuplicates {
    public static boolean[] map = new boolean[26];
    public static void removeDuplicates(String str,int index ,String newString){
        if(index==str.length()){
            System.out.println(newString);
            return;
        }
          if(map[str.charAt(index) - 'a']){   //if true       // char-char = integer
              removeDuplicates(str,index+1,newString);
          }else{
              newString+=str.charAt(index);
              map[str.charAt(index) - 'a'] = true;
              removeDuplicates(str,index+1,newString);
          }
    }
    public static void main(String[] args) {
       removeDuplicates("aabcddefae",0,"");
    }
}




