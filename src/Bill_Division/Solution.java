package Bill_Division;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'bonAppetit' function below.
   *
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY bill
   *  2. INTEGER k
   *  3. INTEGER b
   */

  public static void bonAppetit(List<Integer> bill, int k, int b) {
    // Write your code here
    int sum = 0;
    for (int i = 0; i < bill.size(); i++) {
      if (i != k) {
        sum += bill.get(i);
      }
    }
    int annaShare = sum / 2;
    if (annaShare == b) {
      System.out.println("Bon Appetit");
    } else {
      System.out.println(b - annaShare);
    }
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int k = Integer.parseInt(firstMultipleInput[1]);

    List<Integer> bill = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    int b = Integer.parseInt(bufferedReader.readLine().trim());

    Result.bonAppetit(bill, k, b);

    bufferedReader.close();
  }
}
