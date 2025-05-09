package Arrays;
import java.util.Scanner;

// Program to check 3 digit armstrong number
public class CheckArmstrong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int number = scanner.nextInt();
        System.out.println(isArmstrong(number));
    }                                               // to print all 3 digit armstrong numbers
    static boolean isArmstrong(int number){         // for(int i=100;i<1000;i++){
        int n= number;                              //  if(isArmstrong(i) {
        int sum= 0;                                 // System.out.print(i +" ");
        while(n>0){
            int rem= n%10;
            sum+= Math.pow(rem,3);
            n=n/10;
        }
        return sum==number;
    }
}
// To check any length of number
//    static boolean isArmstrong(int number){
//        int originalNumber = number;
//        int numDigits = countDigits(number);
//        int sum = 0;
//
//        while(number > 0){
//            int rem = number % 10;
//            sum += Math.pow(rem, numDigits);
//            number = number / 10;
//        }
//
//        return sum == originalNumber;
//    }
//
//    static int countDigits(int number) {
//        int count = 0;
//        while (number != 0) {
//            number = number / 10;
//            count++;
//        }
//        return count;
//    }
//}