package BinaryTree;

class Univalued {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Helper method: checks if tree is univalued
    public static boolean isUnivalued(Node root) {
        if (root == null) return true;

        if (root.left != null && root.left.data != root.data) return false;
        if (root.right != null && root.right.data != root.data) return false;

        // Check for left and right subtrees
        return isUnivalued(root.left) && isUnivalued(root.right);
    }

    public static void main(String[] args) {
        /*
                 10
               /    \
             10      10
            /  \    / \
          10  10  10  10
        */

        Node root = new Node(10);
        root.left = new Node(10);
        root.right = new Node(1);
        root.left.left = new Node(10);
        root.left.right = new Node(10);
        root.right.left = new Node(10);
        root.right.right = new Node(10);

        if (isUnivalued(root)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
