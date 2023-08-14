package GraphAlgorithms;

import java.io.IOException;
import java.util.*;

public class UndirectedPath {
    private static boolean undirectedPath(List<List<Character>> edges, char source, char destination, boolean useBreadthFirst) {
        Map<Character, List<Character>> graph = buildGraph(edges);

        if (useBreadthFirst) {
            return breadthFirstHasPath(graph, source, destination, new HashSet<>() /* visited */);
        }

        return depthFirstHasPath(graph, source, destination, new HashSet<>() /* visited */);
    }

    private static boolean depthFirstHasPath(Map<Character, List<Character>> graph, char source, char destination, Set<Character> visited) {
        if (source == destination) {
            return true;
        }

        if (visited.contains(source)) {
            return false;
        }
        visited.add(source);

        for (char neighbour: graph.get(source)) {
            if (depthFirstHasPath(graph, neighbour, destination, visited)) {
                return true;
            }
        }

        return false;
    }

    private static boolean breadthFirstHasPath(Map<Character, List<Character>> graph, char source, char destination, Set<Character> visited) {
        Queue<Character> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            char current = queue.poll();

            if (current == destination) {
                return true;
            }

            if (visited.contains(current)) {
                continue;
            }
            visited.add(current);

            queue.addAll(graph.get(current));
        }

        return false;
    }

    private static Map<Character, List<Character>> buildGraph(List<List<Character>> edges) {
        Map<Character, List<Character>> graph = new HashMap<>();

        int firstNode = 0;
        int secondNode = 1;
        for (List<Character> edge: edges) {
            if (!graph.containsKey(edge.get(firstNode))) {
                graph.put(edge.get(firstNode), new ArrayList<>());
            }
            if (!graph.containsKey(edge.get(secondNode))) {
                graph.put(edge.get(secondNode), new ArrayList<>());
            }

            graph.get(edge.get(firstNode)).add(edge.get(secondNode));
            graph.get(edge.get(secondNode)).add(edge.get(firstNode));
        }

        return graph;
    }

    public static void main(String[] args) throws IOException {
        List<List<Character>> edges = new ArrayList<>() {{
            add(Arrays.asList('i', 'j'));
            add(Arrays.asList('k', 'i'));
            add(Arrays.asList('m', 'k'));
            add(Arrays.asList('k', 'l'));
            add(Arrays.asList('o', 'n'));
        }};

        char source = 'i';
        char destination = 'l';
        boolean useBreadthFirst = true;
        if (undirectedPath(edges, source, destination, useBreadthFirst))
            System.out.println("Path found from '" + source + "' to '" + destination + "' using the " + (useBreadthFirst ? "breadth" : "depth") + " first traversal approach");
        else
            System.out.println("Path not found from '" + source + "' to '" + destination + "' using the " + (useBreadthFirst ? "breadth" : "depth") + " first traversal approach");
    }
}
