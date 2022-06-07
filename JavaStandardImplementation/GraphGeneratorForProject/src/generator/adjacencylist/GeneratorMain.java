package generator.adjacencylist;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Generator for adjacency list of a graph
 * </br>Format: 
 * no nodes  _  no_edges
 * </br>
 * for i: 1-> no_edges:
 * </br>
 * fromNode  _  toNode  _  distance 
 * </br>
 * @author gabri
 *
 */
public class GeneratorMain {

	public static void main(String[] args) {
		int noOfTests = 10;
		for(int i = 1; i<= noOfTests; i++) {
			File f = new File("test" + Integer.toString(i-1));
			try {
				Random random = new Random();
				int noNodes = random.nextInt(20*i) + 10;
				int noEdges = random.nextInt(noNodes*2) + 5;
				List<Edge> edgesList = new ArrayList<>();
				StringBuilder fileContent = new StringBuilder();
				fileContent.append(noNodes).append(" ").append(noEdges).append("\n");
				for(int edges = 0; edges < noEdges; edges++) {
					int fromNodeIndex = random.nextInt(noNodes);
					int toNodeIndex = getNextInt(noNodes, fromNodeIndex, random);
					while(edgesList.contains(new Edge(fromNodeIndex, toNodeIndex))) {
						fromNodeIndex = random.nextInt(noNodes);
						toNodeIndex = getNextInt(noNodes, fromNodeIndex, random);
					}
					edgesList.add(new Edge(fromNodeIndex, toNodeIndex));
					fileContent.append(fromNodeIndex).append(" ")
						.append(toNodeIndex).append(" ")
						.append(random.nextInt(20)).append("\n");
				}
				Files.write(Paths.get(f.toURI()), fileContent.toString().getBytes());
				
			} catch (IOException e) {/*Not implemented*/}
		}
	}
		
		private static int getNextInt(int bound, int currentInt, Random random) {
			int nextInt = random.nextInt(bound);
			while(nextInt == currentInt) {
				nextInt = random.nextInt(bound);
			}
			return nextInt;
		}
		
}
	class Edge {
		public int from;
		public int to;
		Edge(int from, int to){
			this.from = from;
			this.to = to;
		}
	}
