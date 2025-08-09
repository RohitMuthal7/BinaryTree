package BinaryTree;

class HeightofTree {

    // Node class definition
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Function to calculate height of binary tree
    public static int height(Node root) {
        // Base Case: Agar node null hai toh height 0
        if (root == null) {
            return 0;
        }

        // Left subtree ki height nikali
        int leftHeight = height(root.left);

        // Right subtree ki height nikali
        int rightHeight = height(root.right);

        // Jo zyada height hai usme +1 (current root node ke liye)
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        /*
             Tree Structure:
                     1
                   /   \
                  2     3
                 /     / \
                4     5   6
                     /
                    7
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);

        System.out.println("Height of the tree is: " + height(root));
    }
}
