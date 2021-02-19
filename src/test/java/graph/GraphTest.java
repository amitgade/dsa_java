package graph;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by amitgade on 19-Feb-2021
 */
public class GraphTest {

    private Graph graph;

    @Before
    public void setUp() throws Exception {
        graph = new Graph(8);
    }

    @Test
    public void breadthFirstSearch() {
        graph.addEdge(0, 1);
        graph.addEdge(1, 4);
        graph.addEdge(4, 6);
        graph.addEdge(6, 0);
        graph.addEdge(1, 5);
        graph.addEdge(5, 3);
        graph.addEdge(3, 0);
        graph.addEdge(5, 2);
        graph.addEdge(2, 7);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 0)");

        graph.BFS(0);
    }

    @Test
    public void depthFirstSearch() {
        graph.addEdge(0, 1);
        graph.addEdge(1, 4);
        graph.addEdge(4, 6);
        graph.addEdge(6, 0);
        graph.addEdge(1, 5);
        graph.addEdge(5, 3);
        graph.addEdge(3, 0);
        graph.addEdge(5, 2);
        graph.addEdge(2, 7);

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 0)");

        graph.DFS(0);
    }
}