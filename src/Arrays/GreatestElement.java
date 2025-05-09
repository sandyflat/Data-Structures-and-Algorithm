package Arrays;

// Program to find the greatest element in an array
public class GreatestElement {
    public static void main(String[] args) {
        int[] arr={3,8,1,23,45,2};
        System.out.println(max(arr));
    }
    static int max(int[] arr){
        int maxValue = arr[0];     // or we can also initialize as maxValue = Integer.MAX_VALUE;
        for (int j : arr) {
            if (j > maxValue) {
                maxValue = j;
            }
        }
        return maxValue;
    }
}
