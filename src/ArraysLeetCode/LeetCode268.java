// https://leetcode.com/problems/missing-number/description/
// Find the missing number.
package ArraysLeetCode;

public class LeetCode268 {
    public static void main(String[] args) {
        int[] arr = {3,0,1};
        System.out.println(findMissingNumber(arr));
    }

    static int findMissingNumber(int[] arr){
        int n = arr.length;
        int totalSum = n * (n + 1) / 2;
        int arraySum = 0;

        for(int i : arr){
            arraySum += i;
        }

        return totalSum - arraySum;
    }
}
