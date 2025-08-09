package BinaryTree;

class DelLefNode {
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
    // Postorder traversal: Left → Right → Root
    public static void postorder(Node root) {
        if (root == null) return;

        postorder(root.left);       // left subtree
        postorder(root.right);      // right subtree
        System.out.print(root.data + " "); // root baad mein print karo
    }
    public static Node LefDel(Node root , int x){
        if(root == null)
            return null;
         root.left = LefDel(root.left, x);
         root.right = LefDel(root.right, x);

        if(root.left == null && root.right == null && root.data == x){
                return null;
            }
        return root;
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
        root.left.left = new Node(3); // 2 ka left child
        root.left.right = new Node(3); // 2 ka right child
        System.out.println("\nPostorder traversal:");

        int x = 3;
         LefDel(root, x);
        postorder(root);

    }
}
