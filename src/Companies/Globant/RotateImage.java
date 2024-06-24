package Companies.Globant;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RotateImage {
    private static void rotate90Degrees(int[][] image) {
        int imageRows = image.length;
        int imageColumns = image[0].length;
        Map<String, Integer> recoverMap = new HashMap<>();

        int replaceColumn = 0;
        for (int row=imageRows - 1; row>=0; row--) {
            for (int col=0; col<imageColumns; col++) {
                int valueToReplace = image[row][col];
                String positionValueToReplace = row + "" + col;

                // Validate if we need to recover a value
                if (recoverMap.containsKey(positionValueToReplace)) {
                    valueToReplace = recoverMap.get(positionValueToReplace);
                }

                // Save position and value to be recovered
                String positionValueToSave = col + "" + replaceColumn;
                recoverMap.put(positionValueToSave, image[col][replaceColumn]);

                image[col][replaceColumn] = valueToReplace;
            }

            replaceColumn++;
        }
    }

    private static void printImage(int[][] image) {
        for (int[] row : image) {
            for (int colValue : row) {
                System.out.print(colValue + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        int [][] image1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        rotate90Degrees(image1);
        printImage(image1);

        System.out.println("=============================================");

        int [][] image2 = {
                {1,  7,  5,  10},
                {2,  9,  3,  23},
                {6,  4,  8,  15},
                {11, 29, 12, 55},
        };
        rotate90Degrees(image2);
        printImage(image2);
    }
}
