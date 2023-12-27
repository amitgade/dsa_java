package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by amitgade on 19-Feb-2021
 */
public class Graph {
    private int V;                     // No. of vertices
    private LinkedList<Integer> adj[]; // Adjacency Lists

    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int vertex, int edge) {
        adj[vertex].add(edge);
    }

    // BFS traversal from a given source s
    void BFS(int source) {
        // Mark all the vertices as not visited (false)
        boolean visited[] = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[source] = true;
        System.out.println(source + " ");
        queue.add(source);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            source = queue.poll();

            // Get all adjacent vertices of the de-queued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adj[source].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    System.out.println(n + " ");
                    queue.add(n);
                }
            }
        }
    }

    // DFS traversal from a given source s
    void DFS(int source) {
        // Mark all the vertices as not visited (false)
        boolean visited[] = new boolean[V];

        // Create a queue for BFS
        Stack<Integer> stack = new Stack<>();
        stack.add(source);

        visited[source] = true;

        while (!stack.isEmpty()) {
            int current = stack.pop();
            System.out.println(current + " ");

            Iterator<Integer> i = adj[current].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    stack.add(n);
                }
            }
        }
    }
}
