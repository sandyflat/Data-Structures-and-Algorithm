// Program to reverse string
package String;

public class StringReverse {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("hello");
        for(int i=0;i<sb.length()/2;i++){
            int frontIndex = i;
            int backIndex = sb.length()-1-i;

            char frontChar= sb.charAt(frontIndex);
            char backChar= sb.charAt(backIndex);

            sb.setCharAt(frontIndex,backChar);
            sb.setCharAt(backIndex,frontChar);
        }
        System.out.println(sb);
    }
}

// another method
//String str = "hello";
// String rev="";
// for(int i=str.length()-1;i>=0;i--){
// rev = rev + str.charAt(i);
// }
// System.out.println("reverse is "+ rev);
