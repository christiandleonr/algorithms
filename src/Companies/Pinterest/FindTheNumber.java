package Companies.Pinterest;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of numbers <i>arr</i> and a target <i>target</i>
 * return true if you can find the target by any combination of multiplication or additions
 * of all the number in <i>arr</i> which gives the target.
 */
public class FindTheNumber {
    /**
     * [2, 3, 5] -> target 25
     *                          2
     *                     /          \
     *                    +3          *3
     *                  /    \      /    \
     *                 +5    *5   +5     *5
     *                (15)  (25) (11)   (30)
     */
    private static boolean findTheNumber(List<Integer> arr, int target, int current, int index) {
        if (index >= arr.size() - 1) {
            return current == target;
        }

        index++;
        return findTheNumber(arr, target, current + arr.get(index), index)
                ||  findTheNumber(arr, target, current * arr.get(index), index);
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(2, 3, 5);

        boolean result = findTheNumber(arr, 25, arr.get(0), 0);
        System.out.println(result);
    }
}
