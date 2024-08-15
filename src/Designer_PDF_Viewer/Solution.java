package Designer_PDF_Viewer;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

  public static int designerPdfViewer(List<Integer> h, String word) {
    // Write your code here
    int maxHeight = 0;
    for (int i = 0; i < word.length(); i++) {
      int height = h.get(word.charAt(i) - 'a');
      maxHeight = Math.max(maxHeight, height);
    }
    return maxHeight * word.length();
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    String word = bufferedReader.readLine();

    int result = Result.designerPdfViewer(h, word);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
