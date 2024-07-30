package Breaking_the_Records;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'breakingRecords' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER_ARRAY scores as parameter.
   */

  public static List<Integer> breakingRecords(List<Integer> scores) {
    // Write your code here
    int min = scores.get(0);
    int max = scores.get(0);
    int minCount = 0;
    int maxCount = 0;
    List<Integer> result = new ArrayList<>();
    for (int i = 1; i < scores.size(); i++) {
      if (scores.get(i) < min) {
        min = scores.get(i);
        minCount++;
      } else if (scores.get(i) > max) {
        max = scores.get(i);
        maxCount++;
      }
    }
    Collections.addAll(result, maxCount, minCount);
    return result;
  }
}


public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    List<Integer> result = Result.breakingRecords(scores);

    bufferedWriter.write(
            result.stream()
                    .map(Object::toString)
                    .collect(joining(" "))
                    + "\n"
    );

    bufferedReader.close();
    bufferedWriter.close();
  }
}
