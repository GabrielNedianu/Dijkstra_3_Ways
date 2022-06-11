package main.dijkstraimplementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

import main.java.com.dijkstra.DijkstraParallel;
import main.java.com.graph.Graph;

public class Main {

    private static final String INPUT_FILE = "input.txt";

    public static void main(String[] args) {
        Graph graph;
        List<Integer> results = new ArrayList<>();
            //if run with arguments
                //no arguments, default to the parallel method with 4 threads
                graph = readGraph(INPUT_FILE);
                runParallelMethod(graph, 1);
            writeResults("output.txt", results);
    }

    private static List<Integer> runParallelMethod(Graph graph, int nrThreads){
        DijkstraParallel dijkstraParallel = new DijkstraParallel();
        Instant start = Instant.now();
        List<Integer> results = dijkstraParallel.solve(graph, nrThreads);
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println(timeElapsed);
        return results;
    }
    
    public static void writeResults(String fileName, List<Integer> results) {
        File file = new File(fileName);
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(file.toPath())) {
            for (Integer result : results) {
                String line;
                if (result < Integer.MAX_VALUE) {
                    line = String.valueOf(result);
                } else {
                    line = "Inf";
                }
                bufferedWriter.append(line).append('\n');
            }
        } catch (IOException e) {/*No implmnt*/}
    }
    
    public static Graph readGraph(String fileName) {
        List<List<Integer>> edges = new ArrayList<>();
        int numberOfEdges;
        int numberOfNodes = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            if (line != null) {
                String[] params = line.split(" ");
                numberOfNodes = Integer.parseInt(params[0]);
                numberOfEdges = Integer.parseInt(params[1]);
            } else {/**/}
            while ((line = bufferedReader.readLine()) != null) {
                List<Integer> row = new ArrayList<>(numberOfNodes);
                String[] params = line.split(" ");
                for (String valS : params) {
                    int val = Integer.parseInt(valS);
                    row.add(val);
                }
                edges.add(row);
            }
            
        } catch (IOException e) { /*...*/}
        return new Graph(0, edges);
    }
}