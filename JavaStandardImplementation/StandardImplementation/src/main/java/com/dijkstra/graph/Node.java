package src.main.java.com.dijkstra.graph;

import java.util.ArrayList;
import java.util.List;

public class Node{
	private String name;
	private int distanceFromSource = Integer.MAX_VALUE;
	private boolean visited = false;
	private List<Edge> edges = new ArrayList<>();
	
	/**
	 * Default constructor
	 */
	public Node() {}
	/**
	 * Constructor
	 * 
	 * @param name The value of the name of the node
	 */
	public Node(String name) {
		this.name = name;
	}
	/**
	 * Constructor
	 * 
	 * @param valueOfTheNode The integer value of the current node
	 */
	public Node(int valueOfTheNode) {
		this.name = Integer.toString(valueOfTheNode);
	}
	
	/**
	 * @param name The value of the name of the node
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return The value of the current node name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return <code>true</code> if this node was visited
	 */
	public boolean isVisited() {
		return visited;
	}
	/**
	 * @param visited <code>true</code> if this node was visited
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	/**
	 * @param edges set the list of edges
	 */
	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}
	/**
	 * @param edge the edge to be added to this node
	 */
	public void addEdge(Edge edge) {
		this.edges.add(edge);
	}
	/**
	 * @return a list with all edges that go from this node
	 */
	public List<Edge> getEdges() {
		return edges;
	}
	/**
	 * @return The Distance to this node from the Source Node
	 */
	public int getDistanceFromSource() {
		return distanceFromSource;
	}
	/**
	 * @param distanceFromSource The Distance to this node from the Source Node
	 */
	public void setDistanceFromSource(int distanceFromSource) {
		this.distanceFromSource = distanceFromSource;
	}
}
