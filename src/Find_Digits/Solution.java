package Find_Digits;

import java.io.*;
import java.util.stream.IntStream;

class Result {

  /*
   * Complete the 'findDigits' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER n as parameter.
   */

  public static int findDigits(int n) {
    // Write your code here
    int count = 0;
    int temp = n;
    while (temp > 0) {
      int digit = temp % 10;
      if (digit != 0 && n % digit == 0) {
        count++;
      }
      temp /= 10;
    }
    return count;
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int t = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, t).forEach(tItr -> {
      try {
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.findDigits(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();
    bufferedWriter.close();
  }
}
