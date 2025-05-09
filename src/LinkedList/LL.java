// singly linkedList implementation
package LinkedList;

public class LL {
    Node head;
    private int size;
    LL(){
        this.size =0;
    }
    class Node{                // Node of linked list
        String data;
        Node next;

        Node(String data){
            this.data = data;
            this.next = null;
            size++;
        }
    }
    // insertion in first of linked list
    public void addFirst(String data){
        Node newNode = new Node(data);
        if(head ==null){
            head = newNode;
           return;
        }
        newNode.next = head;
        head = newNode;
    }
    // insertion in last of Linked List
    public void addLast(String data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
             return;
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
    }
    // print all list
    public void printList(){
        if(head == null){
            System.out.println("List is empty !!!");
            return;
        }
        Node currentNode = head;
        while(currentNode != null){
            System.out.print(currentNode.data +"->");
            currentNode = currentNode.next;
        }
        System.out.print("null");
    }
    // delete node form first
    public void removeFirst(){
        if(head ==null){
            System.out.println("Linked list is empty !!!");
            return;
        }
        size--;
        head = head.next;
    }
    // delete node from last
    public void removeLast(){
        if(head == null){
            System.out.println("Linked list is empty !!!1");
            return;
        }
        size--;
        if(head.next == null){
            head =null;
            return;
        }
        Node secondLastNode = head;
        Node lastNode =head.next;
        while(lastNode.next != null){
            lastNode = lastNode.next;
            secondLastNode= secondLastNode.next;
        }
        secondLastNode.next = null;
    }
    // get size of linked list
    public int getSize(){
        return size;
    }
    // method to reverse the linked list
    public void reverseIterate(){
        if(head == null || head.next == null){
            return;
        }
        Node prevNode = head;
        Node currentNode = head.next;
        while (currentNode != null){
            Node nextNode = currentNode.next;
            currentNode.next = prevNode;

            // update
            prevNode= currentNode;
            currentNode = nextNode;
        }
        head.next =null;
        head=prevNode;
    }

    public static void main(String[] args) {
        LL list = new LL();
        list.addFirst("sandip");
        list.addFirst("is");
        list.addLast("name");
        list.addLast("chapain");
        list.printList();

        list.removeLast();
        list.printList();
        System.out.println(list.getSize());
        list.reverseIterate();
        list.printList();
    }
}
