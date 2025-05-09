package QueueUsingArray;

public class QueueClass {                         // In this we take add() - 0(1)
    int[] arr;                                          // remove() & peek() - 0(n)
    int front;
    int rear;


    QueueClass(int size){

        arr = new int[size];

        rear =-1;
    }
    boolean isFull(){
        return rear ==arr.length-1;
    }
    boolean isEmpty(){
        return rear == -1;
    }
    void push(int data){                              // Enqueue Operation
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        arr[++rear] = data;
        System.out.println(data + " is added in the queue.");
    }
    void pop(){                                      // Dequeue Operation
        if(isEmpty()){
            System.out.println("Queue is empty.");
            return;
        }
        front= arr[0];
        for(int i = 0;i<rear;i++){
            arr[i]= arr[i+1];
        }
        rear --;
        System.out.println(front +" is popped from the queue.");


    }
    int peek(){
        if(isEmpty()){
            System.out.println("queue is empty.");
            return -1;
        }
        System.out.println(arr[0] + " is the peek value.");
        return arr[0];
    }

    public static void main(String[] args) {
        QueueClass qc = new QueueClass(3);
        qc.push(1);
        qc.push(2);
        qc.push(3);


        while(!qc.isEmpty()){
            System.out.println(qc.peek());
            qc.pop();
        }
    }
}
