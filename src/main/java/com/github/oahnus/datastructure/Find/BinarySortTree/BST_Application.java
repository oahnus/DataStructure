package com.github.oahnus.datastructure.Find.BinarySortTree;

/**
 * Created by oahnus on 2016/8/12.
 */
public class BST_Application {

    public static void main(String[] args){
        //Preorder binary sort tree to get the key code ordered sequence
        int[] array = new int[]{63,55,90,42,58,70,10,45,67,83};

        BinarySortTree bst = new BinarySortTree(array);
        TreeNode node = bst.find(63);

        System.out.println("data:"+node.data);
        System.out.println("left child:"+(node.leftChild!=null?node.leftChild.data:"null"));
        System.out.println("right child:"+(node.rightChild!=null?node.rightChild.data:"null"));
        bst.insert(68);

        bst.delete(63);

        node = bst.find(67);

        System.out.println("data:"+node.data);
        System.out.println("left child:"+(node.leftChild!=null?node.leftChild.data:"null"));
        System.out.println("right child:"+(node.rightChild!=null?node.rightChild.data:"null"));
        node = bst.find(70);

        System.out.println("data:"+node.data);
        System.out.println("left child:"+(node.leftChild!=null?node.leftChild.data:"null"));
        System.out.println("right child:"+(node.rightChild!=null?node.rightChild.data:"null"));


    }
}
