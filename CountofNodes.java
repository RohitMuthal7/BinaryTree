package BinaryTree;

class CountofNodes {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Function to count all nodes
    public static int countNodes(Node root) {
        if (root == null) {
            return 0; // no node = count is 0
        }

        int leftCount = countNodes(root.left);   // count in left subtree
        int rightCount = countNodes(root.right); // count in right subtree

        return leftCount + rightCount + 1; // +1 for the current node
    }

    public static void main(String[] args) {
        /*
                 10
                /  \
               5    15
              / \     \
             3   7     18
        */
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.right = new Node(18);

        int totalCount = countNodes(root);
        System.out.println("Total Number of Nodes = " + totalCount); // Output should be 6
    }
}
