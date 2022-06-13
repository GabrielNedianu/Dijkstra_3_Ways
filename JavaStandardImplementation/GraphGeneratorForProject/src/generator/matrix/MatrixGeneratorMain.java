package generator.matrix;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MatrixGeneratorMain {

	int noTests = 10;
	
	public static void main(String[] args) {
		for(int i = 1; i<= 1; i++) {
			File f = new File("matrixFiles/TestMatrix" + Integer.toString(i-1));
			try {
				Random random = new Random();
				int noNodes =6;
				int noEdges = random.nextInt(noNodes*2) + noNodes;
				int[][] matrix = new int[noNodes][noNodes];
				List<Edge> edgesList = new ArrayList<>();
				StringBuilder fileContent = new StringBuilder();
				fileContent.append(noNodes).append(" ").append(noEdges).append("\n");
				for(int nd = 0; nd < noNodes; nd++) {
					matrix[nd][nd] = 0;
				}
				for(int edges = 0; edges < noEdges; edges++) {
					int fromNodeIndex = random.nextInt(noNodes);
					int toNodeIndex = getNextInt(noNodes, fromNodeIndex, random);
					while(edgesList.contains(new Edge(fromNodeIndex, toNodeIndex))) {
						fromNodeIndex = random.nextInt(noNodes);
						toNodeIndex = getNextInt(noNodes, fromNodeIndex, random);
					}
					edgesList.add(new Edge(fromNodeIndex, toNodeIndex));
					matrix[fromNodeIndex][toNodeIndex] = random.nextInt(20) + 1;
					matrix[toNodeIndex][fromNodeIndex] = matrix[fromNodeIndex][toNodeIndex];
				}
				for(int m = 0; m < noNodes; m++) {
					for(int n = 0; n < noNodes; n++) {
						fileContent.append(matrix[m][n]).append(" ");
					}
					fileContent.append("\n");
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
