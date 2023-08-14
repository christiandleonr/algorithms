package GraphAlgorithms;

import java.io.IOException;
import java.util.*;

public class ShortestPath {
    private static int shortestPath(List<List<Character>> edges, char source, char destination) {
        Map<Character, List<Character>> graph = buildGraph(edges);
        Set<Character> visited = new HashSet<>();
        visited.add(source);

        Queue<List<?>> queue = new LinkedList<>();
        queue.add(Arrays.asList(source, 0));

        while (!queue.isEmpty()) {
            List<?> current = queue.poll();
            char currentNode = (Character) current.get(0);
            int currentDistance = (Integer) current.get(1);

            if (currentNode == destination) {
                return currentDistance;
            }

            for (char node : graph.get(currentNode)) {
                if (!visited.contains(node)) {
                    visited.add(node);
                    queue.add(Arrays.asList(node, currentDistance + 1));
                }
            }
        }

        return -1;
    }

    private static Map<Character, List<Character>> buildGraph(List<List<Character>> edges) {
        Map<Character, List<Character>> graph = new HashMap<>();

        for (List<Character> edge : edges) {
            char firstNode = edge.get(0);
            char secondNode = edge.get(1);

            if (!graph.containsKey(firstNode)) {
                graph.put(firstNode, new ArrayList<>());
            }
            if (!graph.containsKey(secondNode)) {
                graph.put(secondNode, new ArrayList<>());
            }

            graph.get(firstNode).add(secondNode);
            graph.get(secondNode).add(firstNode);
        }

        return graph;
    }

    public static void main(String[] args) throws IOException {
        List<List<Character>> edges = new ArrayList<>() {{
            add(Arrays.asList('w', 'x'));
            add(Arrays.asList('x', 'y'));
            add(Arrays.asList('z', 'y'));
            add(Arrays.asList('z', 'v'));
            add(Arrays.asList('w', 'v'));
        }};

        List<List<Character>> edges_1 = new ArrayList<>() {{
            add(Arrays.asList('a', 'c'));
            add(Arrays.asList('a', 'b'));
            add(Arrays.asList('c', 'b'));
            add(Arrays.asList('c', 'd'));
            add(Arrays.asList('b', 'd'));
            add(Arrays.asList('e', 'd'));
            add(Arrays.asList('g', 'f'));
        }};

        int result = shortestPath(edges_1, 'b', 'g');
        System.out.println(result);
    }
}
