package linkedlist;

/**
 * Created by amitgade on 29-Jan-2021
 */
public class LinkedList {
    private static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }

    }

    private Node head;
    private int size;

    public void addFront(int data) {
        // create new Node
        Node newNode = new Node(data);

        // if head
        if (head == null) {
            head = newNode;
            size++;
            return;
        }

        // set it's next to current head
        newNode.next = head;
        head = newNode;

        // increment size
        size++;
    }

    public int getSize() {
        return size;
    }

    public int getFirst() {
        return head.data;
    }

    public int getLast() {
        if (head == null) {
            throw new IllegalStateException("Empty List");
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }

    public void addBack(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            size++;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        size++;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void deleteValue(int data) {

        // if head is null
        if (head == null) {
            return;
        }

        // if we are to delete head
        if (head.data == data) {
            head = head.next;
            size--;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                size--;
                return;
            }
            current = current.next;
        }
    }
}
