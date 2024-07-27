package Between_Two_Sets;

import java.io.*;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'getTotalX' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY a
   *  2. INTEGER_ARRAY b
   */

  public static int getTotalX(List<Integer> a, List<Integer> b) {
    // Function to calculate the gcd of two numbers
    BiFunction<Integer, Integer, Integer> gcd = (x, y) -> {
      while (y != 0) {
        int temp = y;
        y = x % y;
        x = temp;
      }
      return x;
    };

    // Function to calculate the lcm of two numbers
    BiFunction<Integer, Integer, Integer> lcm = (x, y) ->
            x * (y / gcd.apply(x, y));

    // Function to calculate the GCD of a list of numbers
    int gcdOfB = b.stream().reduce(b.get(0), (x, y) -> gcd.apply(x, y));
    // Function to calculate the LCM of a list of numbers
    int lcmOfA = a.stream().reduce(a.get(0), lcm::apply);
    // Count integers that are multiples of lcmOfList and divisors of gcdOfList
    int count = 0;
    for (int i = lcmOfA, j = 2; i <= gcdOfB; i = lcmOfA * j, j++) {
      if (gcdOfB % i == 0) {
        count++;
      }
    }
    return count;
  }

  public static class Solution {
    public static void main(String[] args) throws IOException {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

      int n = Integer.parseInt(firstMultipleInput[0]);

      int m = Integer.parseInt(firstMultipleInput[1]);

      List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
              .map(Integer::parseInt)
              .collect(toList());

      List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
              .map(Integer::parseInt)
              .collect(toList());

      int total = Result.getTotalX(arr, brr);

      bufferedWriter.write(String.valueOf(total));
      bufferedWriter.newLine();

      bufferedReader.close();
      bufferedWriter.close();
    }
  }
}
