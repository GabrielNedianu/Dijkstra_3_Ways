package src.main.java.com.dijkstra;

import java.util.ArrayList;
import java.util.List;

import src.main.java.com.dijkstra.graph.Edge;
import src.main.java.com.dijkstra.graph.Graph;
import src.main.java.com.dijkstra.graph.Node;

public class MainAlg {
	
	public static void main(String[] args) {
		
		List<Node> nodes = new ArrayList<>();
		// Define the edges of the graph
		for(int i = 0; i <= 7; i++) {
			nodes.add(new Node(i));
		}
		
		Edge[] edges =
			{	new Edge(nodes.get(0),nodes.get(2),1),
				new Edge(nodes.get(0),nodes.get(3),4),
				new Edge(nodes.get(0),nodes.get(4),2),
				new Edge(nodes.get(0),nodes.get(1),3),
				new Edge(nodes.get(1),nodes.get(3),2),
				new Edge(nodes.get(1),nodes.get(4),3),
				new Edge(nodes.get(1),nodes.get(5),1),
				new Edge(nodes.get(2),nodes.get(4),1),
				new Edge(nodes.get(3),nodes.get(5),4),
				new Edge(nodes.get(4),nodes.get(5),2),
				new Edge(nodes.get(4),nodes.get(6),7),
				new Edge(nodes.get(4),nodes.get(7),2),
				new Edge(nodes.get(5),nodes.get(6),4),
				new Edge(nodes.get(6),nodes.get(7),5)
			};
		
		// Create the graph
		
		Graph graph = new Graph(edges, nodes.toArray(new Node[0]));
		
		// Update the graph with the shortest distances
		
		graph.calculateShortestDistances();
		
		// Display the graph
		
		System.out.println(graph.toString());
	
	}
}
