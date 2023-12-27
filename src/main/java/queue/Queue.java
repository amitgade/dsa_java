package queue;

/**
 * Created by amitgade on 30-Jan-2021
 */
public class Queue {
    private static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public int getSize() {
        return size;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;

        // first element where head is null
        if (head == null) {
            head = tail;
        }
        size++;
    }

    public int getHead() {
        return head.data;
    }

    public int getTail() {
        return tail.data;
    }

    public int remove() {
        int data = head.data;
        head = head.next;

        // handle queue now being empty
        if (head == null) {
            tail = null;
        }

        size--;
        return data;
    }

    public int peek() {
        return head.data;
    }

    public void printQueue() {

        System.out.println();

        Node current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.print("null\n");

    }
}
