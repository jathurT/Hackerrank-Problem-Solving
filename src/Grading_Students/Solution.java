package Grading_Students;

import java.io.*;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'gradingStudents' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER_ARRAY grades as parameter.
   */

  public static List<Integer> gradingStudents(List<Integer> grades) {
    // Write your code here
    return grades.stream().map(grade -> {
      if (grade < 38)
        return grade;
      int nextMultipleOfFive = (grade / 5 + 1) * 5;
      return nextMultipleOfFive - grade < 3 ? nextMultipleOfFive : grade;
    }).collect(toList());
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
              try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

    List<Integer> result = Result.gradingStudents(grades);

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
