package Companies.Oracle;

import java.util.Arrays;
import java.util.List;

public class PrintSecondLargest {
    private static void printSecondLargest(List<Integer> arr) {
        int first, second;

        first = second = Integer.MIN_VALUE;
        for (Integer integer : arr) {
            if (integer > first) {
                second = first;
                first = integer;
            } else if (integer > second && integer != first) {
                second = integer;
            }
        }

        System.out.println(second);
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(5, 10, 2, 1, 20, 55, 12, 60, 57, 6, 9);
        printSecondLargest(arr);
    }
}
