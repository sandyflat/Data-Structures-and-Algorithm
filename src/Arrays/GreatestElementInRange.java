package Arrays;

// Program to find the greatest element in an array between given range
public class GreatestElementInRange {
    public static void main(String[] args) {
        int[] arr={34,23,45,12,4,9,56,36};
        System.out.println(max(arr,1,4));
    }
    static int max(int[] arr,int startIndex,int endIndex){
        int maxValue=startIndex;
        for(int i=startIndex;i<endIndex;i++){
            if(arr[i]>maxValue){
                maxValue=arr[i];
            }
        }
        return maxValue;
    }

}
