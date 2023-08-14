package CommonCodingProblems;

import java.util.*;

/**
 * Given an array of integers <i>arr</i> and an integer <i>k</i>,
 * find the kth largest element.
 */
public class KthLargestElement {
    private static int kthLargestElement(List<Integer> arr, int k) {
        Collections.sort(arr);

        return arr.get(arr.size() - k);
    }

    private static int kthLargestElementPriorityQueue(List<Integer> arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        priorityQueue.addAll(arr);

        for (int i = 0; i < k - 1; i++) {
            priorityQueue.poll();
        }

        return priorityQueue.poll();
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(4, 2, 9, 7, 5, 6, 7, 1, 3);

        int result = kthLargestElement(arr, 1);
        System.out.println(result);

        result = kthLargestElementPriorityQueue(arr, 1);
        System.out.println(result);
    }
}
