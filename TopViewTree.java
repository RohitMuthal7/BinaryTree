package BinaryTree; // Java package (folder jaise socho)

import java.util.*; // Queue, HashMap, LinkedList ke liye import

class TopViewTree {

    // Basic Node structure for a binary tree
    static class Node {
        int data;       // Node ka data
        Node left, right; // Left aur right child pointers

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Custom class to store node + uska horizontal distance (hd)
    static class Info {
        Node node;  // Actual node
        int hd;     // Horizontal Distance from root (root = 0, left = -1, right = +1)

        Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    // Top View logic function
    public static void TopView(Node root) {
        Queue<Info> q = new LinkedList<>(); // Level order traversal ke liye Queue
        HashMap<Integer, Node> map = new HashMap<>(); // hd -> node map to store first top view nodes

        int min = 0, max = 0; // Track min and max horizontal distances to know printing range

        q.add(new Info(root, 0)); // Root node ka horizontal distance = 0
        q.add(null); // Null as a level separator (optional but used here)

        while (!q.isEmpty()) {
            Info curr = q.remove(); // Queue se current Info object nikalo

            if (curr == null) {
                // Agar level end ho gaya, toh next level ke liye null daaldo
                if (q.isEmpty()) break;
                else q.add(null);
            } else {
                // Agar iss hd pe pehla node hai, toh map me store karo
                if (!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);
                }

                // Left child ko queue me daalo with hd - 1
                if (curr.node.left != null) {
                    q.add(new Info(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1); // Update min hd
                }

                // Right child ko queue me daalo with hd + 1
                if (curr.node.right != null) {
                    q.add(new Info(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1); // Update max hd
                }
            }
        }

        // Top view ko left se right print karo using min to max range
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
    }

    public static void main(String[] args) {
        /*
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7

            Top View: 4 2 1 3 7
        */

        Node root = new Node(1); // Root node
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        TopView(root); // Function call to print top view
    }
}
