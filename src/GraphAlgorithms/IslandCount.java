package GraphAlgorithms;

import java.io.IOException;
import java.util.*;

public class IslandCount {
    private static int islandCount(List<List<Character>> grid) {
        Set<String> visited = new HashSet<>();
        int islandCount = 0;
        for (int r=0; r<grid.size(); r++) {
            for (int c=0; c<grid.get(0).size(); c++) {
                if (depthFirstExplore(grid, r, c, visited)) {
                    islandCount++;
                }
            }
        }

        return islandCount;
    }

    private static boolean depthFirstExplore(List<List<Character>> grid, int r, int c, Set<String> visited) {
        boolean rowInbound = r >= 0 && r < grid.size();
        boolean colInbound = c >= 0 && c < grid.get(0).size();

        if (!rowInbound || !colInbound) {
            return false;
        }

        if (grid.get(r).get(c) == 'W') {
            return false;
        }

        String node = r + "," + c;
        if (visited.contains(node)) {
            return false;
        }
        visited.add(node);

        depthFirstExplore(grid, r - 1, c, visited);
        depthFirstExplore(grid, r + 1, c, visited);
        depthFirstExplore(grid, r, c - 1, visited);
        depthFirstExplore(grid, r, c + 1, visited);

        return true;
    }

    public static void main(String[] args) throws IOException {
        List<List<Character>> grid = new ArrayList<>() {{
            add(Arrays.asList('W', 'L', 'W', 'W', 'W'));
            add(Arrays.asList('W', 'L', 'W', 'W', 'W'));
            add(Arrays.asList('W', 'W', 'W', 'L', 'W'));
            add(Arrays.asList('W', 'W', 'L', 'L', 'W'));
            add(Arrays.asList('L', 'W', 'W', 'L', 'L'));
            add(Arrays.asList('L', 'L', 'W', 'W', 'W'));
        }};

        int result = islandCount(grid);
        System.out.println(result);
    }
}
