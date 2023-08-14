package GraphAlgorithms;

import java.io.IOException;
import java.util.*;

public class ConnectedComponentCount {
    private static int connectedComponentCount(Map<Integer, List<Integer>> graph, boolean useBreadthFirst) {
        Set<Integer> visited = new HashSet<>();
        int connectedComponentCount = 0;

        for (int node: graph.keySet()) {
            if (useBreadthFirst) {
                if (breadthFirstTraversal(graph, node, visited)) {
                    connectedComponentCount++;
                }
                continue;
            }
            if (depthFirstTraversal(graph, node, visited)) {
                connectedComponentCount++;
            }
        }

        return connectedComponentCount;
    }

    private static boolean depthFirstTraversal(Map<Integer, List<Integer>> graph, int source, Set<Integer> visited) {
        if (visited.contains(source)) {
            return false;
        }
        visited.add(source);

        for (int node : graph.get(source)) {
            depthFirstTraversal(graph, node, visited);
        }

        return true;
    }

    private static boolean breadthFirstTraversal(Map<Integer, List<Integer>> graph, int source, Set<Integer> visited) {
        if (visited.contains(source)) {
            return false;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (visited.contains(current)) {
                continue;
            }
            visited.add(current);

            queue.addAll(graph.get(current));
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        Map<Integer, List<Integer>> graph = new HashMap<>() {{
            put(0, Arrays.asList(8, 1, 5));
            put(1, List.of(0));
            put(5, Arrays.asList(0, 8));
            put(8, Arrays.asList(0, 5));
            put(2, Arrays.asList(3, 4));
            put(3, Arrays.asList(2, 4));
            put(4, Arrays.asList(3, 2));
        }};

        int result = connectedComponentCount(graph, true);
        System.out.println(result);
    }
}
