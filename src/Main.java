import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");

    List<String> names = Arrays.asList(
            "Reflection", "Collection", "Stream",
            "Structure", "Sorting", "State"
    );

    String concatenedString = names.stream()
            .reduce("", (acc, s) -> acc + " " + s);
    System.out.println(concatenedString);
  }
}