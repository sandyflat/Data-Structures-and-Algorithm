// Program to reverse a String using recursion. O(n) ie n=length of string
package Recursion2;

public class ReverseString {
    public static void printReverse(String str, int index){
        if(index==0){
            System.out.print(str.charAt(index));
            return;
        }
        System.out.print(str.charAt(index));
        printReverse(str,index-1);
    }
    public static void main(String[] args) {
        String str = "hello";
        printReverse(str,str.length()-1);
    }
}
