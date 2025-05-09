package String;
import java.util.Scanner;

// Program to check whether the given string is palindrome or not
public class CheckPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String string = scanner.nextLine();
        System.out.println(isPalindrome(string));
    }
    static boolean isPalindrome(String string){
        if(string==null ||string.length()==0){
            return true;
        }
        string = string.toLowerCase();
        for(int i=0;i<string.length()/2;i++){
            char start= string.charAt(i);
            char end= string.charAt(string.length()-1-i);
          if(start!=end){
              return false;
          }
        }
        return true;
    }

}
// another method
//static boolean isPalindrome(String string){
//    string = string.toLowerCase();
//    int start = 0;
//    int end= string.length()-1;
//    while(start<end){
//        if(string.charAt(start)!=string.charAt(end)){
//            return false;
//        }
//        start++;
//        end--;
//    }
//    return true;
//}
//}
