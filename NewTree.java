package BinaryTree;
class NewTree {
    // Node structure
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Function to mirror the tree
    public static void mirror(Node root) {
        if (root == null) {
            return;
        }

        // Step 1: Swap the left and right child
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Step 2: Recursively call for left & right subtree
        mirror(root.left);
        mirror(root.right);
    }

    // Inorder traversal (to check structure)
    public static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        // Tree:
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Before Mirroring (Inorder):");
        inorder(root);  // 4 2 5 1 3

        mirror(root);

        System.out.println("\nAfter Mirroring (Inorder):");
        inorder(root);  // 3 1 5 2 4
    }
}
