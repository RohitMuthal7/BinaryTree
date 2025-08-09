package BinaryTree;

class SubtreeAnother {

    // ✅ Node class: Ek single node jisme data, left child aur right child hote hain
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // ✅ isIdentical(): Check karta hai ke dono trees bilkul same hain ya nahi
    public static boolean isIdentical(Node node, Node subroot) {
        // Agar dono nodes null hain, matlab end tak match hogaya
        if (node == null && subroot == null) {
            return true;
        }

        // Agar koi ek node null ho gaya ya data match nahi kar raha to false
        else if (node == null || subroot == null || node.data != subroot.data) {
            return false;
        }


        // Agar left subtree match nahi karta to return false
        if (!isIdentical(node.left, subroot.left)) {
            return false;
        }

        // Agar right subtree match nahi karta to return false
        if (!isIdentical(node.right, subroot.right)) {
            return false;
        }

        // Sab kuch match ho gaya
        return true;
    }

    // ✅ isSubtree(): Check karta hai ke subroot tree, root tree ka part hai ya nahi
    public static boolean isSubtree(Node root, Node subroot) {
        // Base case: Agar root null ho gaya to subroot match nahi kar sakta
        if (root == null) {
            return false;
        }

        // Step 1: Check karo current node se subroot start ho raha kya
        if (root.data == subroot.data) {
            // Agar start ho raha to poora identical check karo
            if (isIdentical(root, subroot)) {
                return true;
            }
        }

        // Step 2: Agar current node match nahi kar raha, to left aur right subtree mein check karo
        return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
    }

    // ✅ Main function: Tree build karke check karega kya subroot, root ka part hai
    public static void main(String[] args) {
        // 🔷 Main root tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // 🔶 Subtree jisko check karna hai
        Node subroot = new Node(2);
        subroot.left = new Node(4);
        subroot.right = new Node(5);

        // ✅ Print true/false agar subtree milta hai ya nahi
        System.out.println(isSubtree(root, subroot));
    }
}
