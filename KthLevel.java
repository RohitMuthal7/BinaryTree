package BinaryTree;

class KthLevelTree {

    // Node class — ek node me data aur uske left/right child hote hain
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Function to print all nodes at K-th level (0-based indexing)
    public static void KLevel(Node root, int level, int k) {
        // Base Case: agar root null ho gaya, toh return
        if (root == null) {
            return;
        }

        // Agar current level hi k ke barabar hai, toh print karo
        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }

        // Agar level k tak nahi pahucha, toh left aur right subtree me jaao
        KLevel(root.left, level + 1, k);   // Level badhakar left me
        KLevel(root.right, level + 1, k);  // Level badhakar right me
    }

    public static void main(String[] args) {
        /*
            Tree structure:
                      1
                    /   \
                   2     3
                  / \   / \
                 4   5 6   7
        */

        // Tree banaya gaya
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int k = 2;  // Jis level ke nodes print karne hain

        System.out.println("Nodes at level " + k + ":");
        KLevel(root, 0, k);  // Initial call: level 0 se start
    }
}
