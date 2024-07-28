package Sparse_Arrays;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'matchingStrings' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. STRING_ARRAY stringList
   *  2. STRING_ARRAY queries
   */

  public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
    // Write your code here
//    List<Integer> result = new ArrayList<>();
//    for (String query : queries) {
//      int count = 0;
//      for (String matcher : stringList) {
//        if (Objects.equals(query, matcher)) {
//          count++;
//        }
//      }
//      result.add(count);
//    }
//    return result;
    return queries.stream().map(
                    query -> (int) stringList.stream()
                            .filter(matcher -> Objects.equals(query, matcher))
                            .count())
            .collect(toList()
            );

  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int stringListCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<String> stringList = IntStream.range(0, stringListCount).mapToObj(i -> {
              try {
                return bufferedReader.readLine();
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            })
            .collect(toList());

    int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<String> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
              try {
                return bufferedReader.readLine();
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            })
            .collect(toList());

    List<Integer> res = Result.matchingStrings(stringList, queries);

    bufferedWriter.write(
            res.stream()
                    .map(Object::toString)
                    .collect(joining("\n"))
                    + "\n"
    );

    bufferedReader.close();
    bufferedWriter.close();
  }
}
