package graph;

import java.util.*;

/**
 * Created by amitgade on 24-Feb-2021
 */
public class MyGraph {
    // Map of List o:[AdjList-1], 1:[AdjList-2]...
    // Dynamically add nodes.
    private int numberOfVertices;
    private HashMap<Integer, List<Integer>> adjacentList;

    public MyGraph() {
        adjacentList = new HashMap<>();
        numberOfVertices = 0;
    }

    public void addVertex(int vertex) {
        adjacentList.put(vertex, new ArrayList<>());
        numberOfVertices++;
    }

    public void addEdge(int vertex1, int vertex2) {
        adjacentList.get(vertex1).add(vertex2);
        adjacentList.get(vertex2).add(vertex1);
    }

    public void showConnections() {
        Set<Integer> keys = adjacentList.keySet();
        for (Integer node : keys) {
            List<Integer> list = adjacentList.get(node);
            StringBuilder connections = new StringBuilder();
            for (Integer edge : list) {
                connections.append(edge).append(" ");
            }
            System.out.println(node + " --> " + connections);
        }
    }

    public int getNumberOfVertices() {
        return numberOfVertices;
    }
}
