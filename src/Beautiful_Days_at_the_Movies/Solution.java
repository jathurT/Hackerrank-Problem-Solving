package Beautiful_Days_at_the_Movies;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Result {

  /*
   * Complete the 'beautifulDays' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER i
   *  2. INTEGER j
   *  3. INTEGER k
   */

  public static int beautifulDays(int i, int j, int k) {
    // Write your code here
    int beautifulDays = 0;
    for (int l = i; l <= j; l++) {
      int reversed = reverseNumber(l);
      if (Math.abs(reversed - l) % k == 0) {
        beautifulDays++;
      }
    }
    return beautifulDays;
  }

  private static int reverseNumber(int l) {
    int reversed = 0;
    while (l != 0) {
      int temp = l % 10;
      reversed = (reversed * 10) + temp;
      l = l / 10;
    }
    return reversed;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int i = Integer.parseInt(firstMultipleInput[0]);

    int j = Integer.parseInt(firstMultipleInput[1]);

    int k = Integer.parseInt(firstMultipleInput[2]);

    int result = Result.beautifulDays(i, j, k);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
