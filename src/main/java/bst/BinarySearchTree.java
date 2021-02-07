package bst;

/**
 * Created by amitgade on 07-Feb-2021
 */
public class BinarySearchTree {
    class Node {
        int key;
        String value;
        Node left, right;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }

        Node min() {
            if (left == null) {
                return this;
            } else {
                return left.min();
            }
        }
    }

    Node root;

    public String find(int key) {
        Node node = find(root, key);
        return node == null ? null : node.value;
    }

    private Node find(Node node, int key) {
        if (node == null || node.key == key) {
            return node;
        } else if (key < node.key) {
            return find(node.left, key);
        } else if (key > node.key) {
            return find(node.right, key);
        }
        return null;
    }

    public void insert(int key, String value) {
        root = insertItem(root, key, value);
    }

    private Node insertItem(Node node, int key, String value) {
        // create a node
        Node newNode = new Node(key, value);

        // check if root is empty
        if (node == null) {
            node = newNode;
            return node;
        }

        if (key < node.key) {
            node.left = insertItem(node.left, key, value);
        } else {
            node.right = insertItem(node.right, key, value);
        }
        return node;
    }

    public Node min() {
        return root.min();
    }

    public void delete(int key) {

    }


}
