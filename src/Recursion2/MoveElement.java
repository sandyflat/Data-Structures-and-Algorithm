// Program to move all 'x' to end of the string using recursion. O(n)
package Recursion2;                          // ie axbxxcex = abcexxxx

public class MoveElement {
    public static void moveAllx(String str, int index, int count, String newString){
        if(index==str.length()){
            for(int i=0;i<count;i++){
                newString+='x';
            }
            System.out.print(newString);
            return;
        }
        if(str.charAt(index)=='x'){
            count++;
            moveAllx(str,index+1,count,newString);
        }else{
            newString+=str.charAt(index);
            moveAllx(str,index+1,count,newString);
        }
    }
    public static void main(String[] args) {
       moveAllx("axbxxcex",0,0," ");
    }
}
