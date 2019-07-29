package com.github.oahnus.datastructure.Find.BinarySortTree;

/**
 * Created by oahnus on 2016/8/12.
 */
public class BinarySortTree {
    private int[] tree;
    private TreeNode root = null;
    private int size = 10;

    public BinarySortTree(){
        tree = new int[size];
    }

    public BinarySortTree(int a[]){
        tree = new int[a.length];
        for(int i=0;i<a.length;i++){
            tree[i] = a[i];
            insert(a[i]);
        }
    }

    public void insert(int data){
        if(root == null){
            root = new TreeNode(data);
        }
        else{
            TreeNode curr = root;
            while(true){
                if(curr.data > data){
                    if(curr.leftChild == null) {
                        curr.leftChild = new TreeNode(data);
                        return;
                    }
                    curr = curr.leftChild;
                }else{
                    if(curr.rightChild == null){
                        curr.rightChild = new TreeNode(data);
                        return;
                    }
                    curr = curr.rightChild;
                }
            }
        }
    }

    public TreeNode find(int data){
        if(root == null){
            return null;
        }
        TreeNode curr = root;
        while(curr.data != data){
            if(curr.data>data){
                curr = curr.leftChild;
            }else{
                curr = curr.rightChild;
            }
            if(curr == null){
                return null;
            }
        }
        return curr;
    }

    public void delete(int data){
        if(root == null){
            return;
        }
        TreeNode curr = root;
        TreeNode parent = root;

        while(curr.data != data){
            if(curr.data>data){
                parent = curr;
                curr = curr.leftChild;
            }else{
                parent = curr;
                curr = curr.rightChild;
            }
            if(curr == null){
                throw new RuntimeException("not contains the key");
            }
        }

        //leaf
        if(curr.leftChild==null&&curr.rightChild==null){
            if(parent.leftChild.data == curr.data){
                parent.leftChild = null;
            }else{
                parent.rightChild = null;
            }
        }

        //only has left child or only has right child
        if(parent.rightChild == null){
            if(curr.leftChild != null){
                parent.leftChild = curr.leftChild;
            }else{
                parent.leftChild = curr.rightChild;
            }
        }else if(parent.leftChild == null){
            if(curr.leftChild != null){
                parent.rightChild = curr.leftChild;
            }else{
                parent.rightChild = curr.rightChild;
            }
        }else {
            //has left and right child
            parent = curr;
            TreeNode p = curr.rightChild;
            while (p.leftChild != null) {
                parent = p;
                p = p.leftChild;
            }

            curr.data = p.data;
            if(parent == curr){
                parent.rightChild = p.rightChild;
            }else{
                parent.leftChild = p.rightChild;
            }
            p = null;
        }
    }

//    public TreeNode find(int data){
//        return find(root,data);
//    }
//
//    private TreeNode find(TreeNode r,int data){
//        if(r == null){
//            return null;
//        }
//        if(r.data > data) return find(r.leftChild,data);
//        else if(r.data < data) return find(r.rightChild,data);
//        else return r;
//    }
}
