// Find sub array sum equal to K.
// This approach is done by the concept matching with prefixSum[j] -k = sum
package HashMapQuestions;

import java.util.HashMap;

public class SubArraySum {
    public static int findMaxSum(int[] arr, int k){
        HashMap<Integer, Integer> hashMap = new HashMap<>();  // <sum, frequency>

        hashMap.put(0, 1);    // empty subarray
        int answer = 0;
        int sum = 0;

        for(int j = 0; j<arr.length; j++) {   // here sum= total sum of elements from j to arr.length
            sum += arr[j];

            if(hashMap.containsKey(sum-k)){
                answer += hashMap.get(sum-k);   // answer found
            }

            if(hashMap.containsKey(sum)){
                hashMap.put(sum, hashMap.get(sum) +1);   // update frequency
            }else {
                hashMap.put(sum, 1);    // add new sum with frequency 1
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {10,2,-2,-20,10};
        System.out.println(findMaxSum(arr,-10));
    }
}
