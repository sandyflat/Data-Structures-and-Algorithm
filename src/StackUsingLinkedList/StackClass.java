package StackUsingLinkedList;

public class StackClass {
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            next = null;
        }
    }
    static class Stack{
        public static Node head;
        public static boolean isEmpty(){              // check stack is empty or not
            return head == null;
        }
        public static void push(int data){            // push operation in stack
            Node newNode = new Node(data);
            if(isEmpty()){
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }
        public static int pop(){                      // pop operation in stack
            if(isEmpty()){
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }
        public static int peek(){                   // return top element of stack
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }

    }
    public static void main(String[] args) {
         Stack s = new Stack();
         s.push(1);
         s.push(2);
         s.push(3);
         s.push(4);
         while(!s.isEmpty()){
             System.out.println(s.peek());
             s.pop();
         }
    }
}

// More simplified
//class Node{
//    int data;
//    DryRun.Node next;
//    public Node(int data){
//        this.data = data;
//        next = null;
//    }
//}
//public class StackClass {
//    public static DryRun.Node head;
//    public static boolean isEmpty(){
//        return head ==null;
//    }
//    public void push(int data){
//        DryRun.Node newNode = new DryRun.Node(data);
//        System.out.println(data + " is pushed into the stack");
//        if(isEmpty()){
//            head = newNode;
//            return;
//        }
//        newNode.next = head;
//        head = newNode;
//    }
//    public void pop(){
//        if(isEmpty()){
//            System.out.println("Stack is empty");
//            return;
//        }
//        System.out.println(head.data + " is popped from the stack");
//        head = head.next;
//    }
//    public void peek(){
//        if(isEmpty()){
//            System.out.println("stack is empty");
//            return;
//        }
//        System.out.println(head.data +" is top element in the stack");
//    }
//    public static void main(String[] args) {
//        DryRun.StackClass stackClass = new DryRun.StackClass();
//        stackClass.push(1);
//        stackClass.push(2);
//        stackClass.push(3);
//        stackClass.pop();
//        stackClass.peek();
//    }
//}
