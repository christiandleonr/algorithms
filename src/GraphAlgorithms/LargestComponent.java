package GraphAlgorithms;

import java.io.IOException;
import java.util.*;

public class LargestComponent {
    private static int largestComponent(Map<Integer, List<Integer>> graph, boolean useBreadthFirst) {
        Set<Integer> visited = new HashSet<>();
        int largestComponentSize = 0;
        for (int node: graph.keySet()) {
            if (useBreadthFirst) {
                largestComponentSize = Math.max(breadthFirstExploreSize(graph, node, visited), largestComponentSize);
                continue;
            }
            largestComponentSize = Math.max(depthFirstExploreSize(graph, node, visited), largestComponentSize);
        }

        return largestComponentSize;
    }

    private static int depthFirstExploreSize(Map<Integer, List<Integer>> graph, int source, Set<Integer> visited) {
        if (visited.contains(source)) {
            return 0;
        }
        visited.add(source);

        int size = 1;
        for (int node : graph.get(source)) {
            size += depthFirstExploreSize(graph, node, visited);
        }

        return size;
    }

    private static int breadthFirstExploreSize(Map<Integer, List<Integer>> graph, int source, Set<Integer> visited) {
        if (visited.contains(source)) {
            return 0;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        int size = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (visited.contains(current)) {
                continue;
            }
            visited.add(current);
            size+=1;

            queue.addAll(graph.get(current));
        }

        return size;
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

        int result = largestComponent(graph, true);
        System.out.println(result);
    }
}
