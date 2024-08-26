package Swap_Nodes;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Node {
  int data;
  Node left;
  Node right;

  Node(int data) {
    this.data = data;
    left = null;
    right = null;
  }
}

class Result {

  public static void inOrder(Node root, List<Integer> resultList) {
    if (root == null) {
      return;
    }
    inOrder(root.left, resultList);
    resultList.add(root.data);
    inOrder(root.right, resultList);
  }

  public static void swap(Node root, int k, int level) {
    if (root == null) {
      return;
    }
    if (level % k == 0) {
      Node temp = root.left;
      root.left = root.right;
      root.right = temp;
    }
    swap(root.left, k, level + 1);
    swap(root.right, k, level + 1);
  }

  public static void insert(Node root, List<List<Integer>> indexes) {
    List<Node> queue = new ArrayList<>();
    queue.add(root);

    for (List<Integer> index : indexes) {
      Node current = queue.remove(0);
      int leftData = index.get(0);
      int rightData = index.get(1);

      if (leftData != -1) {
        current.left = new Node(leftData);
        queue.add(current.left);
      }
      if (rightData != -1) {
        current.right = new Node(rightData);
        queue.add(current.right);
      }
    }
  }

  public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {
    List<List<Integer>> result = new ArrayList<>();
    Node root = new Node(1);
    insert(root, indexes);

    for (int query : queries) {
      swap(root, query, 1);
      List<Integer> list = new ArrayList<>();
      inOrder(root, list);
      result.add(list);
    }
    return result;
  }
}


public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<List<Integer>> indexes = new ArrayList<>();

    IntStream.range(0, n).forEach(i -> {
      try {
        indexes.add(
                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
        );
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
              try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

    List<List<Integer>> result = Result.swapNodes(indexes, queries);

    result.stream()
            .map(
                    r -> r.stream()
                            .map(Object::toString)
                            .collect(joining(" "))
            )
            .map(r -> r + "\n")
            .collect(toList())
            .forEach(e -> {
              try {
                bufferedWriter.write(e);
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    bufferedReader.close();
    bufferedWriter.close();
  }
}
