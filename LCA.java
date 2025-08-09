package BinaryTree;

class LCA {

    // Node class: Ek tree ka node jisme data aur left/right child hote hain
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Function to find LCA (Lowest Common Ancestor) of two given nodes in a Binary Tree
    public static Node lca(Node root, int n1, int n2) {

        // BASE CASE 1: Agar root hi null ho, toh null return karo
        if (root == null) {
            return null;
        }

        // BASE CASE 2: Agar root ka data kisi ek node ke barabar hai (n1 ya n2)
        // toh wahi root potential LCA ho sakta hai, usko return kar do
        if (root.data == n1 || root.data == n2) {
            return root;
        }

        // Recurse left subtree me n1 aur n2 dhundho
        Node leftLca = lca(root.left, n1, n2);

        // Recurse right subtree me bhi dhundho
        Node rightLca = lca(root.right, n1, n2);

        // AGAR:
        // Left aur Right dono se non-null mila => iska matlab
        // n1 ek side hai, n2 dusri side hai → current root hi LCA hai
        if (leftLca != null && rightLca != null) {
            return root;
        }

        // AGAR:
        // Dono me se sirf ek side se result mila, toh wahi LCA hoga
        // Kyunki dono nodes ek hi side me hain
        return (leftLca != null) ? leftLca : rightLca;
    }

    public static void main(String[] args) {
        /*
            Tree Structure:
                      1
                    /   \
                   2     3
                  / \   / \
                 4   5 6   7
        */

        // Tree banaya ja raha hai
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // In do nodes ke beech ka LCA dhundhna hai
        int n1 = 5, n2 = 7;

        // Function call aur result print
        Node lcaNode = lca(root, n1, n2);
        System.out.println("Lowest Common Ancestor of " + n1 + " and " + n2 + " is: " + lcaNode.data);
    }
}
