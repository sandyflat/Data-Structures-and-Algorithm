package StackUsingArrayList;

import java.util.ArrayList;

public class StackClass {
   static class Stack{
      static ArrayList<Integer> list = new ArrayList<>();

        public  boolean isEmpty(){
            return list.size() == 0;
        }
        public  void push(int data){
            list.add(data);
        }
        public  int  pop(){
            if(isEmpty()){
                return -1;
            }
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }
        public  int peek(){
            if(isEmpty()){
                return -1;
            }
            return list.get(list.size()-1);
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        while(!stack.isEmpty()){
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}
