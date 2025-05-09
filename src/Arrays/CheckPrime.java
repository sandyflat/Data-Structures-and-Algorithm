package Arrays;
import java.util.Scanner;

// Program to check whether the number is Prime or not
public class CheckPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int number = scanner.nextInt();
        boolean result= isPrime((number));
        System.out.println(result);
    }                                                // int count=0;
    static boolean isPrime(int number) {            //for(int i=1;i<=number;i++{
        if(number<=1){                              // if(number%i==0){
            return false;                           //  count++;
        }                                            //  }
        int i=2;                                     // if(count==2) then it is prime
        while(i<number){
            if(number%i==0){
                return false;
            }
            i++;
        }
        return true;
        }
    }

