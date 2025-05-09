package CircularQueueUsingArray;

public class CircularQueue {
    int[] arr;
    int front;
    int rear;
    int size;
    public CircularQueue(int size){
        this.size = size;
        arr= new int[size];
        front =-1;
        rear = -1;
    }
    boolean isEmpty(){
        return front ==-1 && rear == -1;
    }
    boolean isFull(){
        return (rear + 1)%size ==front;
    }
    void push(int data){
        if(isEmpty()){
            front =0;
            rear = 0;
            arr[rear] = data;
            System.out.println(data +" is inserted into the queue.");
            return;
        }
        if(isFull()){
            System.out.println("Queue is full.");
            return;
        }
        rear= (rear +1)%size;
        arr[rear] = data;
        System.out.println(data + " is inserted into the queue.");
    }
    void pop(){
        if(isEmpty()){
            System.out.println("Queue is empty.");
            return;
        }
        if(front==rear){
            System.out.println(arr[rear] + " is popped from the queue.");
            front =-1;
            rear = -1;
            return;
        }
        System.out.println(arr[front] +" is popped from the queue.");
        front = (front+1)%size;
    }
    void peek(){
        if(isEmpty()){
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println(arr[front] +" is the peek element. ");
    }

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);
        cq.push(1);
        cq.pop();
        cq.push(2);
    }
}
