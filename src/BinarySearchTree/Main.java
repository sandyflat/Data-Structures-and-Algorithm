package BinarySearchTree;

public class Main {
    public static void main(String[] args) {
       BST tree = new BST();
       int[] nums = {5,2,7,1,4,6,9,8,3,10};
       int[] nums2 = {1,2,3,4,5,6,7};
       tree.populate(nums);
       tree.displayInPictorial();
       System.out.println(tree.isTreeBalanced());
    }
}
