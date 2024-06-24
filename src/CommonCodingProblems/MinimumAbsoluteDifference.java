package CommonCodingProblems;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class ResultMinimumAbsoluteDifference {

    /*
     * Complete the 'minimumAbsoluteDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int minimumAbsoluteDifference(List<Integer> arr) {
        List<Integer> differences = new ArrayList<>();
        for (int i=0; i<arr.size(); i++) {
            for (int j = i + 1; j <= arr.size() - 1; j++) {
                differences.add(Math.abs(arr.get(i) - arr.get(j)));
            }
        }

        Collections.sort(differences);
        return differences.get(0);
    }

}

public class MinimumAbsoluteDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = ResultMinimumAbsoluteDifference.minimumAbsoluteDifference(arr);
        System.out.println(result);

        bufferedReader.close();
    }
}
