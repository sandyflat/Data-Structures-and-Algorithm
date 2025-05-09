// Leetcode 1672. Richest Customer Wealth
// You are given an m*n integer grid accounts where accounts[i][j] is the amount of money
// the ith customer has in the jth bank. Return the wealth that the richest customer has.
// A customer's wealth is the amount of money they have in all their bank accounts.
// The richest customer is the customer that has the maximum wealth.
// Input: accounts = {{1,2,3,},3,2,1}
// Output: 6
// Explanation:
// 1st customer has wealth = 1 + 2 + 3 = 6
// 2nd customer has wealth = 3 + 2 + 1 = 6
// Both customers are considered the richest with a wealth of 6 each, so return 6.
package LinearSearch;

public class LeetCode1672Easy {
    public static int highestwealth(int[][] arr ) {
        int maxWealth = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
            //  check the sum with maxWealth
            if (sum > maxWealth) {
                maxWealth = sum;
            }
        }
        return  maxWealth;
    }

    public static void main(String[] args) {
        int[][] accounts = {{1,2,3},{4,2,1}};
        System.out.println(highestwealth(accounts));
    }
}
// another approach
//    public static int hightestWealth(int[][] arr ){
//        int[] sum = new int[arr.length];
//        int totalWealth = 0;
//        for(int i = 0; i<arr.length;i++){
//            for(int j = 0; j<arr[i].length; j++){
//                totalWealth+=arr[i][j];
//            }
//            sum[i] = totalWealth;
//            totalWealth =0;
//        }
//        int max = sum[0];
//        for(int i = 0; i<sum.length; i++){
//            if(sum[i]>max){
//                max = sum[i];
//            }
//        }
//        return max;
//    }



