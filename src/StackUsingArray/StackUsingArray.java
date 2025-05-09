package StackUsingArray;

public class StackUsingArray {

    int size;
    int top;
    int[] stackArr;
    public StackUsingArray(int size){
        this.size=size;
        top=-1;
        stackArr= new int[size];
    }
    void push(int data){
        if(top<size-1){
            stackArr[++top]=data;
            System.out.println(data+"is inserted into the stack");
        }else{
            System.out.println("stack is full !!!!");
        }
    }

    void pop(){
        if(top>=0){
            int poppedValue= stackArr[top--];
            System.out.println(poppedValue+ "is popped from stack");
        }else{
            System.out.println("Stack is empty!!!");
        }
    }
    void peek(){
        if(top>=0){
            int topElement = stackArr[top];
            System.out.println(topElement+"is the top element");
        }else{
            System.out.println("Stack is empty !!!!");
        }
    }
    public boolean isEmpty() {
        if (top == -1) {
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        StackUsingArray obj= new StackUsingArray(5);
        obj.push(40);
        obj.push(50);
        obj.push(60);
        obj.pop();
        obj.peek();
        System.out.println("Our stack is empty ????"+obj.isEmpty());
    }
}
