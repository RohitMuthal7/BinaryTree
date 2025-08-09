package BinaryTree; // Package ka naam (folder jaisa)

import java.util.*; // Java ke built-in tools ka import (abhi zarurat nahi but thik hai)

class BinTree {

    // 🔶 Node class jo ek tree ka ek node banata hai
    static class Node {
        int data;         // Data/value store karne ke liye
        Node left;        // Left child ka reference
        Node right;       // Right child ka reference

        // ✅ Constructor - jab new node banate hain to data set karo aur dono child null rakho
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // 🔷 Binary Tree banane wali class
    static class BinaryTree0 {
        static int idx = -1;  // Array ke index track karne ke liye global variable

        // ✅ Tree build karne ka method (Preorder traversal ka format use karta hai)
        public static Node buildTree(int nodes[]) {
            idx++; // Pehle index ko ek aage badhao

            // Agar current index pe -1 mila, to iska matlab yahan koi node nahi — return null
            if (nodes[idx] == -1) {
                return null;
            }

            // New node banao current value se
            Node newNode = new Node(nodes[idx]);

            // Recursively left aur right subtree build karo
            newNode.left = buildTree(nodes);  // Left child
            newNode.right = buildTree(nodes); // Right child
            // Final node return karo
            return newNode;
        }

        public static void levelOrder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // 🔰 Input array diya gaya hai jo tree ke nodes represent karta hai (Preorder form)
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        // Tree builder class ka object banao
        BinaryTree0 tree = new BinaryTree0();

        // buildTree() call karke root node le lo
        Node root = tree.buildTree(nodes);
        tree.levelOrder(root);

        // Sirf root ka data print kar rahe hain
//        System.out.println(root.data);
    }
}
