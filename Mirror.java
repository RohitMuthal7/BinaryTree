package BinaryTree;

import java.util.*; // For Queue and LinkedList

public class Mirror {

    // Node class to represent each node in the binary tree
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Function to perform level order traversal (Breadth-First Search)
    public static void levelOrder(Node root) {
        if (root == null) return;

        // Create a queue to process nodes level by level
        Queue<Node> q = new LinkedList<>();
        q.add(root); // Add the root node to start traversal

        while (!q.isEmpty()) {
            // Remove the front node from the queue
            Node current = q.remove();

            // Print the current node's data
            System.out.print(current.data + " ");

            // Add the left child to the queue if it exists
            if (current.left != null) {
                q.add(current.left);
            }

            // Add the right child to the queue if it exists
            if (current.right != null) {
                q.add(current.right);
            }
        }
    }

    // Function to mirror the binary tree recursively
    public static Node Mir(Node root) {
        // Base case: if the node is null, return null
        if (root == null) {
            return null;
        }

        // Recursively mirror the left and right subtrees
        Node leftside = Mir(root.left);
        Node rightside = Mir(root.right);

        // Swap the left and right children of the current node
        root.left = rightside;
        root.right = leftside;

        // Return the current node (now mirrored)
        return root;
    }

    // Main method to test the mirror operation
    public static void main(String[] args) {
        /*
                 Original Tree:
                     1
                    / \
                   2   3
                  / \   \
                 4   5   6
        */

        // Creating the binary tree structure
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println("Level Order Traversal of Mirrored Tree:");

        // Mirroring the tree
        Mir(root);

        // Performing level order traversal of the mirrored tree
        levelOrder(root);  // Expected Output: 1 3 2 6 5 4
    }
}
