package graph;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by amitgade on 24-Feb-2021
 */
public class MyGraphTest {

    private MyGraph myGraph;
    
    @Before
    public void setUp() throws Exception {
        myGraph = new MyGraph();
    }

    @Test
    public void showConnections() {
        myGraph.addVertex(0);
        myGraph.addVertex(1);
        myGraph.addVertex(2);
        myGraph.addVertex(3);
        myGraph.addVertex(4);
        myGraph.addVertex(5);
        myGraph.addVertex(6);
        myGraph.addEdge(0,1);
        myGraph.addEdge(0,2);
        myGraph.addEdge(1,2);
        myGraph.addEdge(1,3);
        myGraph.addEdge(2,4);
        myGraph.addEdge(3,4);
        myGraph.addEdge(4,5);
        myGraph.addEdge(5,6);
        myGraph.showConnections();


    }
}