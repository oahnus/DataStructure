package Tree.BinaryLinkedList;

import java.util.Random;

/**
 * Created by oahnus on 2016/8/2.
 */
public class TreeApplication {
    public static void main(String[] args){
        Random random = new Random();
        BinaryTree binaryTree = new BinaryTree();
        TreeNode head = null;
        for(int i=0;i<10;i++){
            head = binaryTree.insert(head,random.nextInt(100));
        }
        printTree(head);
    }

    public static void printTree(TreeNode node){
        if(node == null){
            return;
        }
        printTree(node.leftChild);
        System.out.println(node.value);
        printTree(node.rightChild);
        return;
    }
}
