package QueueUsingLinkedList;

public class LinkedClass{
    static class Node {
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }
    static class Queue{
        static Node head = null;
        static Node tail = null;
        public static boolean isEmpty(){
            return head == null && tail == null;
        }
        public static void add(int data){
            Node newNode = new Node(data);
            if(tail == null){                  // in case of empty
                tail = head = newNode;
                return;
            }
            tail.next = newNode;
            tail= newNode;
        }
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int front = head.data;
            if(head == tail){
                tail = null;
            }
            head= head.next;
            return front;
        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return head.data;
        }

        public static void main(String[] args) {
            Queue queue = new Queue();
            queue.add(1);
            queue.add(2);
            queue.add(3);
            queue.add(4);
            queue.add(5);

            while(!queue.isEmpty()){
                System.out.println(queue.peek());
                queue.remove();
            }
        }
    }


}