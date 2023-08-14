package CommonCodingProblems;

import java.util.Arrays;
import java.util.List;

/**
 * Given a sorted array of integers <i>arr</i> and an integer
 * <i>target</i>, find the index and last position of <i>target</i> in
 * <i>arr</i>, if <i>target</i> cannot be found in <i>arr</i> return [-1,-1]
 */
public class FirstAndLastIndex {
    private static List<Integer> firstAndLastIndex(List<Integer> sortedList, int target) {
        int sortedListSize = sortedList.size();
        int start;

        for (int i=0; i<sortedListSize; i++) {
            if (sortedList.get(i) == target) {
                start = i;
                while (i+1 < sortedListSize && sortedList.get(i+1) == target) {
                    i += 1;
                }

                return Arrays.asList(start, i);
            }
        }

        return Arrays.asList(-1, -1);
    }

    private static List<Integer> firstAndLastIndexBS(List<Integer> sortedList, int target) {
        if (sortedList.size() == 0 || sortedList.get(0) > target || sortedList.get(sortedList.size() - 1) < target) {
            return Arrays.asList(-1, -1);
        }
        int start = findStartIndex(sortedList, target);
        int end = findEndIndex(sortedList, target);

        return Arrays.asList(start, end);
    }

    private static int findStartIndex(List<Integer> sortedList, int target) {
        if (sortedList.get(0) == target) {
            return 0;
        }

        int left = 0;
        int right = sortedList.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (sortedList.get(mid) == target && sortedList.get(mid - 1) < target) {
                return mid;
            } else if (sortedList.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    private static int findEndIndex(List<Integer> sortedList, int target) {
        int lastIndex = sortedList.size() - 1;
        if (sortedList.get(lastIndex) == target) {
            return lastIndex;
        }

        int left = 0;
        int right = lastIndex;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (sortedList.get(mid) == target && sortedList.get(mid + 1) > target) {
                return mid;
            } else if (sortedList.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        List<Integer> sortedList = Arrays.asList(2, 4, 5, 5, 5, 5, 5, 7, 9, 9, 10);

        List<Integer> result = firstAndLastIndex(sortedList, 10);
        System.out.println(result);

        result = firstAndLastIndexBS(sortedList, 10);
        System.out.println(result);
    }
}
