// Frequency Counting
// Given an integer array of size n, find all elements that appear more than n/3 times.
// nums[] = {1,3,2,5,1,3,1,5,1};   answer is 1
// nusm[] = {1,2};   answer is 1,2
package HashMapQuestions;
import java.util.*;

public class FrequencyCount {
    public static void majorityElement(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<nums.length; i++){
            if(map.containsKey(nums[i])){        // if true
                map.put(nums[i], map.get(nums[i]) + 1);    // increase frequency by 1
            }else{
                map.put(nums[i], 1);   // element comes first time
            }
        }

        for(int key: map.keySet()){
            if(map.get(key) > nums.length/3){
                System.out.println(key);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,5,1,3,1,5,1};
        majorityElement(nums);
    }
}
