package src.main.java.com.dijkstra;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import src.main.java.com.dijkstra.graph.Edge;
import src.main.java.com.dijkstra.graph.Graph;
import src.main.java.com.dijkstra.graph.Node;

public class MainAlg {
	
	/**
	 * The number of tests
	 */
	private static int noOfTests = 10;
	
	public static void main(String[] args) throws Exception {
		
		int noNodes;
		int noEdges;
		
		for(int i = 0; i < noOfTests; i++) {
			
			System.out.println("\n\n------------------ TEST: " + Integer.toString(i + 1) + " -------------------\n\n");
			
			List<String> allLines = Files.readAllLines(Paths.get(new File("resources/test" + i).toURI()));
			String[] firstLine = allLines.get(0).split(" ");
			noNodes = Integer.parseInt(firstLine[0]);
			noEdges = Integer.parseInt(firstLine[1]);
			
			List<Node> nodes = new ArrayList<>();
			List<Edge> edges = new ArrayList<>();
			
			for(int node = 0; node < noNodes; node++) {
				nodes.add(new Node(node));
			}
			
			for(int line = 1; line <= noEdges; line++) {
				String[] edgeLine = allLines.get(line).split(" ");
				edges.add(new Edge(
						nodes.get(Integer.parseInt(edgeLine[0])),
						nodes.get(Integer.parseInt(edgeLine[1])),
						Integer.parseInt(edgeLine[2])));
			}
			
			// Create the graph
			Graph graph = new Graph(edges.toArray(new Edge[0]), nodes.toArray(new Node[0]));
			
			// Update the graph with the shortest distances
			
			graph.calculateShortestDistances();
			
			// Display the graph
			System.out.println(graph.toString());
		}
	}
}
