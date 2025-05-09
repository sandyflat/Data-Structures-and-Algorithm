package BinarySearchTree;

public class BST {
    public class Node{
        private int value;
        private int height;
        private Node left;
        private Node right;

        public Node(int value){
            this.value = value;
        }

        public int getValue(){
            return value;
        }
    }
    private Node root;

    public BST(){

    }

    public int height(Node node){
        if(node == null) {
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty(){
        return root == null;
    }
    public void insert(int value){
        root = insert(value, root);
    }

    private Node insert(int value, Node node){
        if(node == null){
            node = new Node(value);
            return node;
        }

        if(value < node.value){
            node.left = insert(value, node.left);
        }

        if(value > node.value){
            node.right = insert(value, node.right);
        }
        node.height = Math.max(height(node.left),height(node.right)) +1;

        return node;
    }

    // wants to enter multiple values at a time. For array
    public void populate(int[] nums){
        for (int i = 0; i< nums.length; i++){
            this.insert(nums[i]);
        }
    }

    // if array is sorted and we have to create a balanced tree.
    public void populatedSorted(int[] nums){
        populatedSorted(nums, 0, nums.length);
    }

    private void populatedSorted(int[] nums, int start, int end){
        if(start >= end){
            return;
        }
        int mid = (start + end)/2;      // binary search concept
        this.insert(nums[mid]);    // insert mid element
        populatedSorted(nums, start, mid-1);    // do for left sub array
        populatedSorted(nums, mid + 1, end);  // do for right sub array

    }

    public boolean isTreeBalanced(){
        return isTreeBalanced(root);
    }

    private boolean isTreeBalanced(Node node){
        if(node == null){
            return true;
        }

        return Math.abs(height(node.left) - height(node.right)) <= 1 && // this checks for root
                isTreeBalanced(node.left) && isTreeBalanced(node.right); // this for rest of the nodes
    }

    // display
    public void display(){
        display(this.root, "Root Node: ");
    }
    private void display(Node node, String details){
        if(node == null){
            return;
        }
        System.out.println(details + node.getValue());
        display(node.left, "Left child of " + node.getValue() + " : ");
        display(node.right, "Right child of " + node.getValue() + " : ");
    }

    // display in pictorial form
    public void displayInPictorial(){
        displayInPictorial(this.root, "");
    }

    private void displayInPictorial(Node node,String indent){
        if(node == null){
            return;
        }
        System.out.println(indent + node.value);
        displayInPictorial(node.left, indent + "\t");
        displayInPictorial(node.right, indent +"\t");
    }

}
