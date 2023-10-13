package CommonCodingProblems;

import java.util.*;

/**
 * Given an integer <i>n</i> representing the number of courses (courses are labeled from 0 to n-1),
 * and an array of prerequisites where prerequisites[i] = [a,b] means that you first need to take
 * the course <i>b</i> before taking the course <i>a</i>, determine if it's possible to finish all
 * the courses
 */
public class CourseSchedule {
    private static boolean courseSchedule(int n, List<List<Integer>> prerequisites) {
        Map<Integer, List<Integer>> graph = buildGraph(prerequisites);
        Set<Integer> visited = new HashSet<>();
        List<Integer> order = new LinkedList<>();
        for (int course=0; course<n; course++) {
            if (!visited.contains(course)) {
                visited.add(course);
                if (!depthFirst(course, graph, visited, new HashSet<>(), order)) {
                    System.out.println("Order: " + order);
                    return false;
                }
            }
        }

        System.out.println("Order: " + order);
        return true;
    }

    private static boolean courseScheduleBreathFirst(int n, List<List<Integer>> prerequisites) {
        int[] inDegrees = new int[n];
        Map<Integer, List<Integer>> graph = buildGraph(prerequisites, inDegrees);

        List<Integer> order = new LinkedList<>();
        return breathFirst(n, graph, inDegrees, order);
    }

    private static boolean depthFirst(int vertex, Map<Integer, List<Integer>> graph, Set<Integer> visited, Set<Integer> path, List<Integer> order) {
        path.add(vertex);

        for (Integer neighbor: graph.get(vertex)) {
            if (path.contains(neighbor)) {
                return false;
            }
            if (visited.contains(neighbor)) {
                continue;
            }
            visited.add(neighbor);

            if (!depthFirst(neighbor, graph, visited, path, order)) {
                return false;
            }
        }

        path.remove(vertex);
        order.add(vertex);
        return true;
    }

    private static boolean breathFirst(int n, Map<Integer, List<Integer>> graph, int[] inDegrees, List<Integer> order) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            order.add(vertex);

            for (Integer neighbor: graph.get(vertex)) {
                inDegrees[neighbor] -= 1;
                if (inDegrees[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        System.out.println("Order: " + order);
        return order.size() == n;
    }

    private static Map<Integer, List<Integer>> buildGraph(List<List<Integer>> prerequisites) {
        return buildGraph(prerequisites, null);
    }

    private static Map<Integer, List<Integer>> buildGraph(List<List<Integer>> prerequisites, int[] inDegree) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (List<Integer> relationship: prerequisites) {
            int prerequisite = relationship.get(1);
            int dependent = relationship.get(0);

            if (!graph.containsKey(prerequisite)) {
                graph.put(prerequisite, new ArrayList<>());
            }
            if (!graph.containsKey(dependent)) {
                graph.put(dependent, new ArrayList<>());
            }

            graph.get(prerequisite).add(dependent);

            if (inDegree != null && inDegree.length > 0)
                inDegree[dependent] += 1;
        }

        return graph;
    }

    public static void main(String[] args) {
        int n = 6;

        List<List<Integer>> prerequisites = new ArrayList<>();
        prerequisites.add(Arrays.asList(3, 0));
        prerequisites.add(Arrays.asList(0, 1));
        prerequisites.add(Arrays.asList(1, 3));
        prerequisites.add(Arrays.asList(2, 1));
        prerequisites.add(Arrays.asList(4, 1));
        prerequisites.add(Arrays.asList(4, 2));
        prerequisites.add(Arrays.asList(5, 3));
        prerequisites.add(Arrays.asList(5, 4));

        System.out.println(courseSchedule(n, prerequisites));
        System.out.println(courseScheduleBreathFirst(n, prerequisites));
    }
}
