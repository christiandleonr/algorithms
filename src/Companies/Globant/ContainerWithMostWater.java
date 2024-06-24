package Companies.Globant;

import java.io.IOException;
import java.util.*;

public class ContainerWithMostWater {
    public static void resolve(List<Integer> heights) {
        int maxWaterArea = 0;
        int heightsSize = heights.size();

        for (int i=0; i<heightsSize; i++) {
            int startHeightSize = heights.get(i);

            for (int j=i; j<heightsSize; j++) {
                if (i == j) {
                    continue;
                }

                int endHeightSize = heights.get(j);
                int xAxisDistance = Math.abs(i - j);
                int minHeightSize = Math.min(startHeightSize, endHeightSize);

                int currentWaterArea = xAxisDistance * minHeightSize;
                if (maxWaterArea < currentWaterArea) {
                    maxWaterArea = currentWaterArea;
                }
            }
        }

        System.out.println(maxWaterArea);
    }

    public static void main(String[] args) throws IOException {
        List<Integer> heights = Arrays.asList(2, 1, 2);

        resolve(heights);
    }
}
