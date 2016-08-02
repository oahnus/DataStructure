package Tree.BinaryLinkedList;

import java.util.Random;

/**
 * Created by oahnus on 2016/8/2.
 */
public class BinaryTree {
    public BinaryTree(){}

    private Random random = new Random();

    public TreeNode<Integer> newNode(int data){
        TreeNode<Integer> node = new TreeNode<>();
        node.leftChild = null;
        node.rightChild = null;
        node.value = data;
        return node;
    }

    public TreeNode<Integer> insert(TreeNode<Integer> node,int data){
        if(node == null){
            return newNode(data);
        }
        else{
            if(data>node.value){
                node.rightChild = insert(node.rightChild,data);
            }else{
                node.leftChild = insert(node.leftChild,data);
            }
        }
        return node;
    }
}
