package Arrays;
import java.util.Arrays;

//  we can take variable length of arguments like this
public class VarArgs {
    public static void main(String[] args) {
        func(2,3,4,5,6,7);
    }
    static void func(int ...v){
        System.out.println(Arrays.toString(v));
    }
}
