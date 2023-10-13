package CommonCodingProblems;

import java.util.Arrays;
import java.util.List;

/**
 * Given a circular list of gas stations, where we can go
 * from a station <i>i</i> to the station <i>i+1</i>, and the last one goes
 * back to the first one, find the index of the station from where
 * we start to be able to traverse all the stations and go back
 * to the initial one without running out of gas.
 */
public class GasStation {
    private static boolean canGoBack(List<Integer> gas, List<Integer> cost, int start) {
        int n = gas.size();
        int remaining = 0;
        int i = start;
        boolean started = false;

        while (i != start || !started) {
            started = true;

            remaining += gas.get(i) - cost.get(i);
            if (remaining < 0) return false;

            i = (i+1)%n;
        }

        return true;
    }

    private static int gasStation(List<Integer> gas, List<Integer> cost) {
        for (int i=0; i<gas.size(); i++) {
            if (canGoBack(gas, cost, i)) {
                return i;
            }
        }

        return -1;
    }

    private static int gasStationOptimized(List<Integer> gas, List<Integer> cost) {
        int remaining = 0;
        int prevRemaining = 0;
        int candidate = 0;
        int n = gas.size();
        for (int i=0; i<gas.size(); i++) {
            remaining = gas.get(i) - cost.get(i);
            if (remaining < 0) {
                prevRemaining = remaining;
                remaining = 0;
                candidate = i + 1;
            }
        }

        if (candidate == n || remaining + prevRemaining < 0) {
            return -1;
        } else return candidate;
    }

    public static void main(String[] args) {
        List<Integer> gas = Arrays.asList(1, 5, 3, 3, 5, 3, 1, 3, 4, 5);
        List<Integer> cost = Arrays.asList(5, 2, 2, 8, 2, 4, 2, 5, 1, 2);

        System.out.println(gasStation(gas, cost));

        System.out.println(gasStationOptimized(gas, cost));
    }
}
