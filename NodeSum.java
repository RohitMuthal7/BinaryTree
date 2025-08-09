package BinaryTree;

class SumOfNodes {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Function to calculate sum of all nodes
    public static int sumOfNodes(Node root) {
        if (root == null) {
            return 0; // base case: empty node contributes 0
        }

        int leftSum = sumOfNodes(root.left);   // Recursively sum left subtree
        int rightSum = sumOfNodes(root.right); // Recursively sum right subtree

        return leftSum + rightSum + root.data; // total = left + right + root's data
    }

    public static void main(String[] args) {
        // Creating a sample tree
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

        int totalSum = sumOfNodes(root);
        System.out.println("Total Sum of Nodes = " + totalSum); // Output should be 10+5+15+3+7+18 = 58
    }
}
