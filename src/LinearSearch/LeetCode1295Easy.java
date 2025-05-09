// LeetCode 1295.Find numbers with Even number of digits
// Given an array 'nums' of integers, return how many of them contain an even
// number of digits.
// Input: nums =[12,345,2,6,7896]
// Output: 2  ie 12 contains 2 digits, 7896 contains 4 number of digits (even).

package LinearSearch;
public class LeetCode1295Easy {
    public static boolean checkEven(int data){
        if(data ==0){
            return false;
        }
        int number = data;
        int count = 0;
        while(number>0){
            count++;
            number= number/10;
        }
        if(count%2 ==0){
            return true;
        }else{
            return false;
        }
    }
    public static int returnEven(int[] arr){
        int count = 0;
        for(int i = 0; i<arr.length; i++){
            if(checkEven(arr[i])){
                count++;
            }
        }
        return count;
    }

    // To count the digits of number we can also do this
    public static int countDigits(int number){
        return (int)(Math.log10(number)) +1;
    }

    public static void main(String[] args) {
        int[] nums = {12,345,2,6,7896};
        System.out.println(returnEven(nums));
        System.out.println(countDigits(12345));
    }
}
