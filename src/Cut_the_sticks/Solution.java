package Cut_the_sticks;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'cutTheSticks' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public static List<Integer> cutTheSticks(List<Integer> arr) {
    // Write your code here
    List<Integer> result = new ArrayList<>();
    Collections.sort(arr);
    while (!arr.isEmpty()) {
      result.add(arr.size());
      int min = arr.get(0);
      arr.removeIf(i -> i == min);
    }
    return result;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    List<Integer> result = Result.cutTheSticks(arr);

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
