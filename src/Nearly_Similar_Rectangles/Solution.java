package Nearly_Similar_Rectangles;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



class Result {

  /*
   * Complete the 'nearlySimilarRectangles' function below.
   *
   * The function is expected to return a LONG_INTEGER.
   * The function accepts 2D_LONG_INTEGER_ARRAY sides as parameter.
   */

  public static long nearlySimilarRectangles(List<List<Long>> sides) {
    // Write your code here
    long result = 0;
    Map<Double, Long> map = new HashMap<>();
    for (List<Long> side : sides) {
      double ratio = (double) side.get(0) / side.get(1);
      map.put(ratio, map.getOrDefault(ratio, 0L) + 1);
    }
    for (long count : map.values()) {
      result += count * (count - 1) / 2;
    }
    return result;
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int sidesRows = Integer.parseInt(bufferedReader.readLine().trim());
    int sidesColumns = Integer.parseInt(bufferedReader.readLine().trim());

    List<List<Long>> sides = new ArrayList<>();

    for (int i = 0; i < sidesRows; i++) {
      String[] sidesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

      List<Long> sidesRowItems = new ArrayList<>();

      for (int j = 0; j < sidesColumns; j++) {
        long sidesItem = Long.parseLong(sidesRowTempItems[j]);
        sidesRowItems.add(sidesItem);
      }

      sides.add(sidesRowItems);
    }

    long result = Result.nearlySimilarRectangles(sides);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
