package stack;

import java.util.EmptyStackException;

/**
 * Created by amitgade on 30-Jan-2021
 */
public class Stack {
    private static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    private int size;
    private Node head;

    public void push(int data) {
//        if (head == null) {
//            head = newNode;
//            size++;
//            return;
//        }
        Node newNode = new Node(data);
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
        size++;
    }

    public int pop() {
        if (head == null) {
            throw new EmptyStackException();
         }
        int data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public int peek() {
        return head.data;
    }

}
