package SubArray_Forum;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

  /*
   * Complete the 'findSum' function below.
   *
   * The function is expected to return a LONG_INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY numbers
   *  2. 2D_INTEGER_ARRAY queries
   */

  public static List<Long> findSum(List<Integer> numbers, List<List<Integer>> queries) {
    // Write your code here
    int n = numbers.size();

    // Create prefix sum and prefix zero count arrays
    long[] prefixSum = new long[n + 1];
    int[] prefixZeroCount = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      prefixSum[i] = prefixSum[i - 1] + numbers.get(i - 1);
      prefixZeroCount[i] = prefixZeroCount[i - 1] + (numbers.get(i - 1) == 0 ? 1 : 0);
    }

    List<Long> results = new ArrayList<>();

    for (List<Integer> query : queries) {
      int l = query.get(0);
      int r = query.get(1);
      int x = query.get(2);

      // Calculate the sum of the subarray [l, r]
      long subarraySum = prefixSum[r] - prefixSum[l - 1];

      // Calculate the number of zeros in the subarray [l, r]
      int zeroCount = prefixZeroCount[r] - prefixZeroCount[l - 1];

      // Add the extra sum due to zeros
      subarraySum += (long) zeroCount * x;

      results.add(subarraySum);
    }

    return results;
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int numbersCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> numbers = IntStream.range(0, numbersCount).mapToObj(i -> {
              try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

    int queriesRows = Integer.parseInt(bufferedReader.readLine().trim());
    int queriesColumns = Integer.parseInt(bufferedReader.readLine().trim());

    List<List<Integer>> queries = new ArrayList<>();

    IntStream.range(0, queriesRows).forEach(i -> {
      try {
        queries.add(
                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
        );
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    List<Long> result = Result.findSum(numbers, queries);

    bufferedWriter.write(
            result.stream()
                    .map(Object::toString)
                    .collect(joining("\n"))
                    + "\n"
    );

    bufferedReader.close();
    bufferedWriter.close();
  }
}
