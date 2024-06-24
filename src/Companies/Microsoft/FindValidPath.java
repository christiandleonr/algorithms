package Companies.Microsoft;

import java.util.*;

public class FindValidPath {
    private static final List<Character> locks = Arrays.asList('<','>','v','^','x');
    
    private static boolean findValidPath(List<String> stringsGrid) {
        List<List<Character>> grid = adjustGrid(stringsGrid);

        List<Integer> startPosition = new ArrayList<>();
        findStartPosition(grid, startPosition);
        int startRow = startPosition.get(0);
        int startCol = startPosition.get(1);

        printGrid(grid);

        Set<String> visited = new HashSet<>();
        return breadthFirstExplore(grid, startRow, startCol, visited);
    }

    private static boolean breadthFirstExplore(List<List<Character>> grid, int startRow, int startCol, Set<String> visited) {
        Queue<String> queue = new LinkedList<>();

        String coordinates = startRow + "," + startCol;
        queue.add(coordinates);

        while (!queue.isEmpty()) {
            String currentCoordinate = queue.poll();
            int row = Integer.parseInt(currentCoordinate.split(",")[0]);
            int col = Integer.parseInt(currentCoordinate.split(",")[1]);

            boolean rowInbound = row >= 0 && row < grid.size();
            boolean colInbound = col >= 0 && col < grid.get(0).size();
            if (!rowInbound || !colInbound) {
                continue;
            }

            char currentStepValue = grid.get(row).get(col);

            if (visited.contains(currentCoordinate)) {
                continue;
            }
            visited.add(currentCoordinate);

            if (locks.contains(currentStepValue)) {
                continue;
            }

            if (currentStepValue == 'D') {
                return true;
            }

            String left = (row - 1) + "," + col;
            queue.add(left);

            String up = row + "," + (col - 1);
            queue.add(up);

            String right = (row + 1) + "," + col;
            queue.add(right);

            String down = row + "," + (col + 1);
            queue.add(down);
        }

        return false;
    }
    
    private static boolean depthFirstExplore(List<List<Character>> grid, int r, int c, Set<String> visited) {
        boolean rowInbound = r >= 0 && r < grid.size();
        boolean colInbound = c >= 0 && c < grid.get(0).size();
        
        if (!rowInbound || !colInbound) {
            return false;
        }
        
        if (locks.contains(grid.get(r).get(c))) {
            return false;
        }
        
        if (grid.get(r).get(c) == 'D') {
            return true;
        }
        
        String coordinates = r + "," + c;
        if (visited.contains(coordinates)) {
            return false;
        }
        visited.add(coordinates);

        return depthFirstExplore(grid, r - 1, c, visited) ||
                depthFirstExplore(grid, r + 1, c, visited) ||
                depthFirstExplore(grid, r, c - 1, visited) ||
                depthFirstExplore(grid, r, c + 1, visited);
    }

    private static List<List<Character>> adjustGrid(List<String> stringsGrid) {
        List<List<Character>> grid = new ArrayList<>();

        for (String row : stringsGrid) {
            List<Character> rowChars = new ArrayList<>();
            for (char character : row.toCharArray()) {
                rowChars.add(character);
            }
            grid.add(rowChars);
        }
        setLocks(grid);
        return grid;
    }

    private static void setLocks(List<List<Character>> grid) {
        int rows = grid.size();
        for (int r=0; r<rows; r++) {
            int columns = grid.get(0).size();

            for (int c=0; c<columns; c++) {
                int currentC = c;
                int currentR = r;

                if (grid.get(r).get(c) == '<') {
                    while (currentC > 0) {
                        currentC--;
                        grid.get(r).set(currentC, 'x');
                    }
                }

                if (grid.get(r).get(c) == '>') {
                    while (currentC < columns - 1) {
                        currentC++;
                        grid.get(r).set(currentC, 'x');
                    }
                }

                if (grid.get(r).get(c) == '^') {
                    while (currentR > 0) {
                        currentR--;
                        grid.get(currentR).set(c, 'x');
                    }
                }

                if (grid.get(r).get(c) == 'v') {
                    while (currentR < rows - 1) {
                        currentR++;
                        grid.get(currentR).set(c, 'x');
                    }
                }
            }
        }
    }

    private static void findStartPosition(List<List<Character>> grid, List<Integer> startPosition) {
        int rows = grid.size();

        outerLoop:
        for (int r=0; r<rows; r++) {
            int columns = grid.get(0).size();

            for (int c = 0; c < columns; c++) {
                if (grid.get(r).get(c) == 'S') {
                    startPosition.add(r);
                    startPosition.add(c);

                    break outerLoop;
                }
            }
        }
    }

    private static void printGrid(List<List<Character>> grid) {
        System.out.println("================================================");
        for (List<Character> row: grid) {
            System.out.println(row);
        }
        System.out.println("================================================");
    }

    /**
     * S -> Start position
     * D -> Destiny
     * <>^v -> Guards
     * x -> locks
     *
     * . . . < . . .
     * . . x . D v .
     * S . x . . . .
     * . . . . . . .
     *
     * =
     *
     * x x x < . . .
     * . . x . D v .
     * S . x . . x .
     * . . . . . x .
     * @param args
     */
    public static void main(String[] args) {
        List<String> grid = Arrays.asList(
                ".....<D",
                "..x...v",
                "S.x....",
                ".....^."
        );

        System.out.println(findValidPath(grid));
    }
}
