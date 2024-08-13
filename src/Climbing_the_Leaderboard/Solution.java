package Climbing_the_Leaderboard;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

  public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
    // Write your code here
    List<Integer> result = new ArrayList<>();
    List<Integer> uniqueRanked = new ArrayList<>();
    uniqueRanked.add(ranked.get(0));
    for (int i = 1; i < ranked.size(); i++) {
      if (!Objects.equals(ranked.get(i), ranked.get(i - 1))) {
        uniqueRanked.add(ranked.get(i));
      }
    }
    int j = uniqueRanked.size() - 1;
    for (Integer scoreOfPlayer : player) {
      while (j >= 0) {
        if (scoreOfPlayer >= uniqueRanked.get(j)) {
          j--;
        } else {
          result.add(j + 2);
          break;
        }
      }
      if (j < 0) {
        result.add(1);
      }
    }
    return result;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    List<Integer> result = Result.climbingLeaderboard(ranked, player);

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
