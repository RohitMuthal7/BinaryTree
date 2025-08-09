package BinaryTree;

class AdvDimTree {

    // Binary Tree ka Node class banaya
    static class Node {
        int data;         // node ki value
        Node left, right; // left aur right child node

        // Constructor – jab bhi node create hoga, data assign hoga aur children null honge
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Tree ki height calculate karne wala function
    public static int height(Node root) {
        if (root == null) {
            return 0; // agar root null hai to height 0 hogi (base case)
        }

        // left aur right subtree ki height nikal rahe hain
        int lh = height(root.left);
        int rh = height(root.right);

        // maximum height + 1 (root ke liye)
        return Math.max(lh, rh) + 1;
    }

    // 💥 Approach 1: Diameter nikalne ka simple (but slow) method
    public static int Diameter(Node root) {
        if (root == null) {
            return 0; // base case: null node ka diameter 0
        }

        // left subtree ka diameter
        int leftDim = Diameter(root.left);
        // left subtree ki height
        int leftHt = height(root.left);

        // right subtree ka diameter
        int rightDim = Diameter(root.right);
        // right subtree ki height
        int rightHt = height(root.right);

        // current node ka diameter = left height + right height + 1 (current node)
        int selfDim = leftHt + rightHt + 1;

        // max of left, right, ya current node ka diameter
        return Math.max(selfDim, Math.max(leftDim, rightDim));
    }

    // ✅ Optimized approach: ek hi traversal mein height + diameter dono nikal rahe hain
    static class Info {
        int Diame; // Diameter
        int ht;    // Height

        // Constructor to initialize height and diameter
        public Info(int Diame, int ht) {
            this.Diame = Diame;
            this.ht = ht;
        }
    }

    // Optimized diameter function – return karta hai Info object
    public static Info Diameter2(Node root) {
        if (root == null) {
            return new Info(0, 0); // null node ke liye height = 0, diameter = 0
        }

        // Left subtree ka info (diameter + height)
        Info leftinfo = Diameter2(root.left);

        // Right subtree ka info (diameter + height)
        Info righinfo = Diameter2(root.right);

        // Self diameter = left height + right height + 1
        int diam = Math.max(Math.max(leftinfo.Diame, righinfo.Diame), leftinfo.ht + righinfo.ht + 1);

        // Self height = max(left.height, right.height) + 1
        int ht = Math.max(leftinfo.ht, righinfo.ht) + 1;

        // return combined Info object
        return new Info(diam, ht);
    }

    // Main method – program execution starts here
    public static void main(String[] args) {

        // Sample tree create kar rahe hain
        /*
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7
        */

        Node root = new Node(1);           // root node
        root.left = new Node(2);           // level 1 - left
        root.right = new Node(3);          // level 1 - right
        root.left.left = new Node(4);      // level 2 - left
        root.left.right = new Node(5);     // level 2 - right
        root.right.left = new Node(6);     // level 2 - left
        root.right.right = new Node(7);    // level 2 - right

        // Optimized diameter calculate kar rahe hain
        System.out.println(Diameter2(root).Diame); // Output: 5
    }
}
