package Array_Manipulation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'arrayManipulation' function below.
   *
   * The function is expected to return a LONG_INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. 2D_INTEGER_ARRAY queries
   */

  public static long arrayManipulation(int n, List<List<Integer>> queries) {
    // Write your code here
//    Array Difference Approach
//    Time Complexity: O(n + m)
    long[] arr = new long[n + 1]; // Note: Extra element for easier boundary handling
    for (List<Integer> query : queries) {
      int a = query.get(0);
      int b = query.get(1);
      int k = query.get(2);
      arr[a - 1] += k;
      arr[b] -= k;
    }
    long max = 0;
    long sum = 0;
    for (long l : arr) {
      sum += l;
      max = Math.max(max, sum);
    }
    return max;
  }

  public class Solution {
    public static void main(String[] args) throws IOException {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

      int n = Integer.parseInt(firstMultipleInput[0]);

      int m = Integer.parseInt(firstMultipleInput[1]);

      List<List<Integer>> queries = new ArrayList<>();

      IntStream.range(0, m).forEach(i -> {
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

      long result = Result.arrayManipulation(n, queries);

      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();

      bufferedReader.close();
      bufferedWriter.close();
    }
  }
}
