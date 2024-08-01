package Migratory_Birds;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'migratoryBirds' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public static int migratoryBirds(List<Integer> arr) {
    // Write your code here
    int[] count = new int[6];
    for (int i = 0; i < arr.size(); i++) {
      count[arr.get(i)]++;
    }
    int maxCount = Arrays.stream(count).max().getAsInt();
    int maxIndex = 0;
    for (int i = 1; i < count.length; i++) {
      if (count[i] == maxCount) {
        maxIndex = i;
        break;
      }
    }
    return maxIndex;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    int result = Result.migratoryBirds(arr);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
