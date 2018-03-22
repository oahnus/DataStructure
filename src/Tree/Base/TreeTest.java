package Tree.Base;



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

    public static void delete(TreeNode node, int val) {
        if (node == null) {
            return;
        }
        if (node.val > val) {
            delete(node.left, val);
        } else if (node.val < val) {
            delete(node.right, val);
        } else {
            if (node.left == null && node.right == null) {
                node = null;
                return;
            } else if (node.left == null) {
                node = node.right;
                return;
            } else if (node.right == null) {
                node = node.left;
                return;
            } else {
                TreeNode leftMaxNode = findMax(node.left);
                TreeNode temp = new TreeNode(leftMaxNode.val);
                temp.right = node.right;
                temp.left = node.left;
                temp.val = leftMaxNode.val;
                node = temp;
                System.out.println(node.val);
                delete(node.left, leftMaxNode.val);
                node.val = 123;
            }
        }
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

        TreeNode maxNode = findMax(node.right.right.left);
        System.out.println(String.format("max val under node %d is %d", node.val, maxNode.val));

        delete(node, 8);
        print(node);
    }
}
