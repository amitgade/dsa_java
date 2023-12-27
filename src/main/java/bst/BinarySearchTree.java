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

    public BinarySearchTree() {
        this.root = null;
    }

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

    public Node findMin() {
        return root.min();
    }

    public void delete(int key) {
        root = deleteItem(root, key);
    }

    private Node deleteItem(Node node, int key) {
        if (node == null) {
            return null;
        } else if (key < node.key) {
            node.left = deleteItem(node.left, key);
        } else if (key > node.key) {
            node.right = deleteItem(node.right, key);
        } else {
            // we find the node to delete
            // case 1: No Child
            if (node.left == null && node.right == null) {
                node = null;
            }

            // case 2: 1 Child
            else if (node.left == null) {
                node = node.right;
            } else if (node.right == null) {
                node = node.left;
            } else {
                // case 3: 2 children
                node = node.right.min();
            }
        }
        return node;
    }

    public void printInOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.key);
            inOrderTraversal(node.right);
        }
    }

    public void printPreOrderTraversal() {
        preOrderTraversal(root);
    }

    private void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.println(node.key);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public void printPostOrderTraversal() {
        postOrderTraversal(root);
    }

    private void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.println(node.key);
        }
    }
}
