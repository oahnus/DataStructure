package Tree.Base;


import org.junit.Test;

/**
 * Created by oahnus on 2018/3/21
 * 23:01.
 */
public class TreeTest {
    public static TreeNode reverseTree(TreeNode node) {
        if (node == null) {
            return null;
        }
        node.left = reverseTree(node.left);
        node.right = reverseTree(node.right);

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        return node;
    }

    public static TreeNode build(int[] arr) {
        TreeNode node = null;
        for (int intVal: arr) {
            node = insert(node, intVal);
        }
        return node;
    }

    public static TreeNode insert(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        if (val > node.val) {
            node.right = insert(node.right, val);
        } else {
            node.left = insert(node.left, val);
        }
        return node;
    }

    public static void print(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        print(node.left);
        print(node.right);
    }

    public static void printBefore(TreeNode node) {
        if (node == null) {
            return;
        }
        printBefore(node.left);
        System.out.print(node.val + " ");
        printBefore(node.right);
    }

    public static boolean contain(TreeNode node, int val) {
        if (node == null) {
            return false;
        }
        if (val == node.val) {
            return true;
        } else if (val > node.val) {
            return contain(node.right, val);
        } else {
            return contain(node.left, val);
        }
    }

    public static int maxDeep(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDeep = maxDeep(node.left);
        int rightDeep = maxDeep(node.right);
        return leftDeep > rightDeep ? leftDeep + 1 : rightDeep + 1;
    }

    public static boolean isLeaf(TreeNode node, int val) {
        if (node == null) {
            return false;
        }
        if (node.val == val) {
            return node.left == null && node.right == null;
        }
        if (val > node.val) {
            return isLeaf(node.right, val);
        } else {
            return isLeaf(node.left, val);
        }
    }

    public static TreeNode findMax(TreeNode node) {
        if (node == null) {
            return null;
        }
        return node.right == null ? node : findMax(node.right);
    }

    public static TreeNode findMix(TreeNode node) {
        if (node == null) {
            return null;
        }
        return node.left == null ? node : findMix(node.left);
    }

    /**
     * @param node root node
     * @param val target val
     * @return target node's parent node
     */
    public static TreeNode findParent(TreeNode node, int val){
        if (node == null || node.val == val) {
            return null;
        }
        if (node.val > val) {
            return node.left != null && node.left.val == val ? node : findParent(node.left, val);
        } else {
            return node.right != null && node.right.val == val ? node : findParent(node.right, val);
        }
    }

    /**
     * delete node
     * @param node root node
     * @param val target node val
     * @return new root node
     */
    public static TreeNode delete(TreeNode node, int val) {
        if (node == null) {
            return null;
        }
        TreeNode parentNode = findParent(node, val);
        // delete root node
        if (parentNode == null) {
            if (node.left == null) {
                node = node.right;
                return node;
            } else {
                TreeNode leftMaxNode = findMax(node.left);
                TreeNode temp = new TreeNode(leftMaxNode.val);
                temp.left = node.left;
                temp.right = node.right;
                node = temp;
                node.left = delete(node.left, leftMaxNode.val);
                return node;
            }
        }
        // target node is parentNode's left node
        if (parentNode.left != null && parentNode.left.val == val) {
            TreeNode targetNode = parentNode.left;
            if (targetNode.left == null && targetNode.right == null) {
                parentNode.left = null;
            } else if (targetNode.left == null) {
                parentNode.left = targetNode.right;
            } else if (targetNode.right == null){
                parentNode.left = targetNode.left;
            } else {
                // use targetNode's max left node replace targetNode
                TreeNode leftMaxNode = findMax(targetNode.left);
                TreeNode temp = new TreeNode(leftMaxNode.val);
                temp.left = targetNode.left;
                temp.right = targetNode.right;
                parentNode.left = temp;
                temp.right = delete(temp.right, leftMaxNode.val);
            }
        }
        // target node is parentNode's right node
        if (parentNode.right != null && parentNode.right.val == val) {
            TreeNode targetNode = parentNode.right;
            if (targetNode.left == null && targetNode.right == null) {
                parentNode.right = null;
            } else if (targetNode.left == null) {
                parentNode.right = targetNode.right;
            } else if (targetNode.right == null){
                parentNode.right = targetNode.left;
            } else {
                // use targetNode's max left node replace targetNode
                TreeNode leftMaxNode = findMax(targetNode.left);
                TreeNode temp = new TreeNode(leftMaxNode.val);
                temp.left = targetNode.left;
                temp.right = targetNode.right;
                parentNode.right = temp;
                temp.left = delete(temp.left, leftMaxNode.val);
            }
        }
        return node;
    }

    public static void main(String... args) {
        int[] arr = new int[]{4, 5, 2, 3, 1, 8, 9, 7, 6};
        TreeNode node = build(arr);
        print(node);
        System.out.println();
        printBefore(node);
        System.out.println();
        node = reverseTree(node);
        print(node);
        node = reverseTree(node);
        System.out.println();

        int num = 6;
        boolean contain = contain(node, num);
        System.out.println("tree contains " + num + " is " + contain);
        int maxDeep = maxDeep(node);
        System.out.println("tree max deep is " + maxDeep);
        boolean isLeaf = isLeaf(node, num);
        System.out.println("num " + num + " is Leaf is " + isLeaf);
        isLeaf = isLeaf(node, 4);
        System.out.println("num " + num + " is Leaf is " + isLeaf);

        TreeNode maxNode = findMax(node.right);
        System.out.println(String.format("max val under node %d is %d", node.right.val, maxNode.val));

        int targetNodeVal = 6;
        TreeNode parent = findParent(node, targetNodeVal);
        System.out.println(String.format("node %s's parent node is %s", targetNodeVal, parent != null ? parent.val : "none"));

        node = delete(node, 8);
        System.out.print("delete node 8 :");
        print(node);
        System.out.println();
        System.out.print("delete node 4");
        node = delete(node, 4);
        print(node);
    }
}
