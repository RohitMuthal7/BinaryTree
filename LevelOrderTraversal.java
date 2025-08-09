package BinaryTree;

import java.util.*; // For Queue and LinkedList

public class LevelOrderTraversal {

    // 🌳 Node class to represent each tree node
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // 📦 Function to perform level order traversal (BFS)
    public static void levelOrder(Node root) {
        if (root == null) return;

        // 🎯 Use a queue to store nodes level by level
        Queue<Node> q = new LinkedList<>();
        q.add(root); // Start from the root

        while (!q.isEmpty()) {
            Node current = q.remove(); // 🛑 Remove the front node
            System.out.print(current.data + " "); //  Print its data

            // 👶 Add left child if it exists
            if (current.left != null) {
                q.add(current.left);
            }

            // 🧒 Add right child if it exists
            if (current.right != null) {
                q.add(current.right);
            }
        }
    }

    // 🚀 Driver code to test
    public static void main(String[] args) {
        /*
                 1
                / \
               2   3
              / \   \
             4   5   6
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println("Level Order Traversal:");
        levelOrder(root); // Output: 1 2 3 4 5 6
    }
}
