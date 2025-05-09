// Program to print keypad combination using recursion. O(4^n)
package Recursion2;

public class KeyCombination {
    public static String[] keypad = {".","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static void printCombination(String str, int index, String combination){
        if(index==str.length()){
            System.out.println(combination);
            return;
        }
        char currChar = str.charAt(index);
        String mapping = keypad[currChar - '0'];

        for(int i=0; i<mapping.length(); i++){
            printCombination(str, index+1, combination+mapping.charAt(i));
        }
    }
    public static void main(String[] args) {
      printCombination("23",0,"");
    }
}

// keypad mobile key combination looks like
// 0 -> .
// 1 -> abc
// 2 -> def
// 3 -> ghi
// 4 -> jkl
// 5 -> mno
// 6 -> pqrs
// 7 -> tu
// 8 -> vwx
// 9 -> yz
