package src.main.java.com.dijkstra.graph;

import java.util.List;

public class Graph {
	
	/**
	 * All the nodes in the Graph
	 */
	private Node[] nodes;
	private Edge[] edges;
	private int noOfNodes;
	private int noOfEdges;

	public Node[] getNodes() {
		return nodes;
	}
	public int getNoOfNodes() {
		return noOfNodes;
	}
	public Edge[] getEdges() {
		return edges;
	}
	public int getNoOfEdges() {
		return noOfEdges;
	}
		
	/**
	 * Constructor that builds the whole graph from an Array of Edges and Nodes
	 */
	public Graph(Edge[] edges, Node[] nodes){
		
		// Store the edges and Nodes
		this.edges = edges;
		this.nodes = nodes;
		this.noOfNodes = nodes.length;
		this.noOfEdges = edges.length;
		
		// Add all the edges to the nodes. Each edge is added to 2 nodes (the "to" and the "from")
		for (int edgeToAdd = 0; edgeToAdd < this.noOfEdges; edgeToAdd++) {
			edges[edgeToAdd].getFromNode().addEdge(edges[edgeToAdd]);
			edges[edgeToAdd].getToNode().addEdge(edges[edgeToAdd]);
		}
		
	}
	
	/**
	 * Uses Dijkstra's algorithm to calculate the shortest distance from the source to all nodes
	 * 
	 */
	public void calculateShortestDistances() {
		
		this.nodes[0].setDistanceFromSource(0);
		int nextNodeIndex = 0;
		
		// Visit every node, in order of stored distance
		for (int i = 0; i < this.nodes.length; i++) {
			List<Edge> currentNodeEdges = this.nodes[nextNodeIndex].getEdges();
			for (int joinedEdge = 0; joinedEdge < currentNodeEdges.size(); joinedEdge++) {

				Node neighbour = currentNodeEdges.get(joinedEdge).getNeighbourNode(nodes[nextNodeIndex]);
				
				if (!neighbour.isVisited()) {
					// Calculate the potential distance for the neighbour
					int potentialValue = this.nodes[nextNodeIndex].getDistanceFromSource() + currentNodeEdges.get(joinedEdge).getLength();
					// Overwrite if the tentative distance is less than what's currently stored
					if (potentialValue < neighbour.getDistanceFromSource()) {
						neighbour.setDistanceFromSource(potentialValue);
					}
				}
			}
			nodes[nextNodeIndex].setVisited(true);
			nextNodeIndex = getNodeShortestDistanced();
		}
	}
	
	/**
	 * Scans the unvisited nodes and calculates which one has the shortest distance from the source.
	 * 
	 * @return The index of the node with the smallest distance
	 */
	private int getNodeShortestDistanced() {
		
		int storedNodeIndex = 0;
		int storedDist = Integer.MAX_VALUE;
		
		for (int i = 0; i < this.nodes.length; i++) {
			int currentDist = this.nodes[i].getDistanceFromSource();			
			if (!this.nodes[i].isVisited() && currentDist < storedDist) {
				storedDist = currentDist;
				storedNodeIndex = i;
			}
			
		}
		
		return storedNodeIndex;
	}
	
	/**
	 * Overrides Object.toString() to show the contents of the graph
	 * 
	 */
	public String toString() {

		StringBuilder output = new StringBuilder();
		output.append("Number of nodes = " + this.noOfNodes);
		output.append("\nNumber of edges = " + this.noOfEdges);

		for (int i = 0; i < this.nodes.length; i++) {
			output.append("\nThe shortest distance from node 0 to node " + i + " is " + nodes[i].getDistanceFromSource());
		}
		
		return output.toString();
	}

}
