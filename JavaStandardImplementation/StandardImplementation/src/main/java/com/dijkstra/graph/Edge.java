package src.main.java.com.dijkstra.graph;

public class Edge {
	private Node fromNode;
	private Node toNode;
	private int length;

	public Edge(Node fromNode, Node toNode, int length) {
		this.fromNode = fromNode;
		this.toNode = toNode;
		this.length = length;
	}

	public Node getFromNode() {
		return fromNode;
	}
	public Node getToNode() {
		return toNode;
	}
	public int getLength() {
		return length;
	}

	/**
	 * Determines the neighbouring node of a supplied node, based on the 2 nodes connected by this edge.
	 * 
	 * @param nodeIndex One of the nodes that this edge joins.
	 * @return The neighbour node.
	 *
	 */
	public Node getNeighbourNode(Node node) {
		if (this.fromNode == node) {
			return this.toNode;
		} else {
			return this.fromNode;
		}
	}
}
