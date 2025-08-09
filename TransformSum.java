package BinaryTree;
class TransformSum {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Step 1: Transform to Sum Tree using Postorder
    public static int toSumTree(Node root) {
        if (root == null) return 0;

        int leftSum = toSumTree(root.left);
        int rightSum = toSumTree(root.right);

        int oldValue = root.data;
        root.data = leftSum + rightSum;

        return root.data + oldValue;
    }

    // Step 2: Preorder traversal (for printing after transformation)
    public static void preorder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        /*
                 10
               /    \
             -2      6
            /  \    / \
           8   -4  7   5
        */

        Node root = new Node(10);
        root.left = new Node(-82);
        root.right = new Node(6);
        root.left.left = new Node(8);
        root.left.right = new Node(-4);
        root.right.left = new Node(70);
        root.right.right = new Node(5);

        System.out.println("Preorder before transformation:");
        preorder(root); // original

        toSumTree(root); // 💥 transform using postorder

        System.out.println("\nPreorder after transforming to Sum Tree:");
        preorder(root); // 🔥 see new values in preorder
    }
}
