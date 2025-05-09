// Check whether the given integer value is palindrome or not.
package Arrays;

public class CheckPalindrome {
    public static void main(String[] args) {
        System.out.println(checkPalindrome(12321));
    }

    public static boolean checkPalindrome(int number){
        int num = number;
        int reverse = 0;

        while (num>0){
            int remainder = num%10;
            reverse = reverse * 10 + remainder;
            num = num/10;
        }
        return reverse==number;
    }
}
