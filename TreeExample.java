package BinaryTree;

class TreeExample {
    // Node class banaya – ye ek binary tree ka node ko represent karta hai
    static class Node {
        int data;
        Node left, right;

        // Constructor: jab naya node banega to usme data set hoga
        public Node(int data) {
            this.data = data;
            right = left = null;
        }
    }

    // Preorder traversal: Root → Left → Right
    public static void preorder(Node root) {
        if (root == null) {
            return; // base case: agar root null hai to kuch nahi karna
        }

        System.out.print(root.data + " "); // pehle root print karo
        preorder(root.left); // fir left subtree
        preorder(root.right); // fir right subtree
    }

    // Inorder traversal: Left → Root → Right
    public static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);         // left subtree pe jao
        System.out.print(root.data + " "); // root print karo
        inorder(root.right);        // right subtree pe jao
    }

    // Postorder traversal: Left → Right → Root
    public static void postorder(Node root) {
        if (root == null) return;

        postorder(root.left);       // left subtree
        postorder(root.right);      // right subtree
        System.out.print(root.data + " "); // root baad mein print karo
    }

    // Main method: yahan se program start hota hai
    public static void main(String[] args) {
        // Tree banate hain manually
        /*
                1
               / \
              2   3
             / \
            4   5
        */

        Node root = new Node(1); // root node
        root.left = new Node(2); // root ka left child
        root.right = new Node(3); // root ka right child
        root.left.left = new Node(4); // 2 ka left child
        root.left.right = new Node(5); // 2 ka right child

        System.out.println("Preorder traversal:");
        preorder(root); // function call

        System.out.println("\nInorder traversal:");
        inorder(root); // function call

        System.out.println("\nPostorder traversal:");
        postorder(root); // function call
    }
}
