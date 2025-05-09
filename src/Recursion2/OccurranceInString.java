// Program to find first and last occurrence of element in String using recursion. O(n)
package Recursion2;

public class OccurranceInString {
    public static int first = -1;
    public static int last = -1;
    public static void findOccurrance(String str, int index, char element){
        if(index==str.length()){
            System.out.println("first occurrance at "+first);
            System.out.println("last occurrancce at "+last);
            return;
        }
        if(str.charAt(index)==element){
            if(first==-1){
                first=index;
            }else{
                last=index;
            }
        }
        findOccurrance(str,index+1,element);
    }
    public static void main(String[] args) {
         String str = "baacdaefaaeghah";
         char element = 'a';
         findOccurrance(str,0,element);
    }
}
