// 🔥 Problem: Find the Kth Ancestor of a given node in a Binary Tree
// 🌱 Approach: Use DFS + Distance Propagation from Target Node
package BinaryTree;

public class KthAncestor {

    // Node class for the tree
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // 🔍 Recursive function to find Kth ancestor
    public static int KAncestor(Node root, int n, int k) {
        // 🚫 Base Case: if root is null, we return -1 (not found in this path)
        if (root == null) {
            return -1;
        }

        // 🎯 If current node is the target node `n`
        if (root.data == n) {
            return 0;  // Distance of node from itself is 0
        }

        // 🌿 Recursively search in left and right subtree
        int leftDist = KAncestor(root.left, n, k);
        int rightDist = KAncestor(root.right, n, k);

        // 🛑 If both left and right return -1 => `n` not found in this subtree
        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }

        // 📏 Calculate max distance from left/right
        int max = Math.max(leftDist, rightDist);

        // 🧠 If current node is k distance away from the target node
        if (max + 1 == k) {
            System.out.println("Kth Ancestor is: " + root.data);
        }

        // 🔁 Return distance from this node to target node `n`
        return max + 1;
    }

    // 🚀 Main function to build tree and test the logic
    public static void main(String[] args) {
        /*
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int node = 5; // target node
        int k = 2;    // k-th ancestor to find

        // Start recursion
        KAncestor(root, node, k);
    }
}
