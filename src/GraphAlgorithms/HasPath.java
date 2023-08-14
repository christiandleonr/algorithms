package GraphAlgorithms;

import java.io.IOException;
import java.util.*;

public class HasPath {
    private static boolean depthFirstHasPath(Map<Character, List<Character>> graph, char source, char destination) {
        if (source == destination) return true;

        for (char c : graph.get(source)) {
            if (depthFirstHasPath(graph, c, destination)) {
                return true;
            }
        }

        return false;
    }

    private static boolean breadthFirstHasPath(Map<Character, List<Character>> graph, char source, char destination) {
        Queue<Character> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            char currentNode = queue.poll();

            if (currentNode == destination) {
                return true;
            }

            queue.addAll(graph.get(currentNode));
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        Map<Character, List<Character>> graph = new HashMap<Character, List<Character>>() {{
            put('a', Arrays.asList('b', 'c'));
            put('b', List.of('d'));
            put('c', List.of('e'));
            put('d', List.of('f'));
            put('e', new ArrayList<>());
            put('f', new ArrayList<>());
        }};

        char source = 'a';
        char destination = 'f';
        if (depthFirstHasPath(graph, source, destination)) {
            System.out.println("Path found from " + source + " to " + destination + " using the depth first traversal approach");
        }
        System.out.println("================================");
        if (breadthFirstHasPath(graph, source, destination)) {
            System.out.println("Path found from " + source + " to " + destination + " using the breadth first traversal approach");
        }
    }
}
