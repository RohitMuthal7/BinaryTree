package BinaryTree;

class MinDistanceNode {

    // 🌱 Node class: Represents one node of the binary tree
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // 🌳 Lowest Common Ancestor (LCA) Finder
    // Finds the first common ancestor between two nodes n1 and n2
    public static Node lca(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLca = lca(root.left, n1, n2);   // Search in left subtree
        Node rightLca = lca(root.right, n1, n2); // Search in right subtree

        if (rightLca == null) return leftLca;    // Only found in left subtree
        if (leftLca == null) return rightLca;    // Only found in right subtree

        return root; // Found in both -> this is the LCA
    }

    // 🔗 Minimum Distance Between Two Nodes
    // Uses the LCA to find distance from LCA to both nodes, then adds them
    public static int minDis(Node root, int n1, int n2) {
        Node LCA = lca(root, n1, n2);             // Step 1: Find LCA of n1 & n2
        int dis1 = lcaDis(LCA, n1);               // Step 2: Distance from LCA to n1
        int dis2 = lcaDis(LCA, n2);               // Step 3: Distance from LCA to n2

        return dis1 + dis2;                       // Step 4: Total Distance
    }

    // 🧭 Distance from LCA to a Target Node (DFS Style Search)
    public static int lcaDis(Node root, int n) {
        if (root == null) return -1;              // Node not found

        if (root.data == n) return 0;             // Reached target node

        int LeftDis = lcaDis(root.left, n);       // Search left subtree
        int RightDis = lcaDis(root.right, n);     // Search right subtree

        // If not found in either subtree
        if (LeftDis == -1 && RightDis == -1) return -1;

            // Found in right subtree
        else if (LeftDis == -1) return RightDis + 1;

            // Found in left subtree
        else return LeftDis + 1;
    }

    // 🧪 Main Method: Execution starts here!
    public static void main(String[] args) {
        // 🔧 Tree Construction
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.right.right.left.left.right = new Node(8);

        // 🎯 Test: Find min distance between 5 and 1
        System.out.println(minDis(root, 5, 1)); // Output will be 2
    }
}
