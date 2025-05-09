// Program to find whether a character is present in the string or not using linear search.
package LinearSearch;

public class LinearSearchString {
    public static boolean linearSearch(String str, char target){
//        for(int i = 0; i<str.length(); i++){         // method 1
//            if(str.charAt(i)==target){
//                return true;
//            }
//        }
        for(char ch : str.toCharArray()){             // method 2 using for each loop.
            if(ch==target){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "hello";
        System.out.println(linearSearch(str,'l'));
    }
}
