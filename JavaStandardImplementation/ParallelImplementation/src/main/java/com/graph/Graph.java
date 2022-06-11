package main.java.com.graph;

import java.util.List;

/**
 * The model of the Graph used for the parallel algorithm
 * 
 * @author gabriel_nedianu
 *
 */
public class Graph {
	/**
	 * The node from where starts the algorithm
	 */
    private int sourceNode;
    /**
     * The list of edges
     */
    private List<List<Integer>> edges;
    /**
     * The number of the nodes
     */
    private int numberOfNodes;

    /**
     * Constructor
     * 
     * @param sourceNode The node from where starts the alg
     * @param edges The list of the edges
     */
    public Graph(int sourceNode, List<List<Integer>> edges) {
        this.sourceNode = sourceNode;
        this.edges = edges;
        this.numberOfNodes = edges.size();
    }

    public int getNumberOfNodes() {
        return numberOfNodes;
    }

    public int getSourceNode() {
        return sourceNode;
    }

    public List<List<Integer>> getEdges() {
        return edges;
    }
}