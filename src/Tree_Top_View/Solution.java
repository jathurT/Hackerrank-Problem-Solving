package Tree_Top_View;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

class Node {
  Node left;
  Node right;
  int data;

  Node(int data) {
    this.data = data;
    left = null;
    right = null;
  }
}

class Solution {

  static class Pair {
    Node node;
    int hd;

    public Pair(Node node, int hd) {
      this.node = node;
      this.hd = hd;
    }
  }

  static void topView(Node root) {
    if (root == null)
      return;
    TreeMap<Integer, Integer> map = new TreeMap<>();
    Queue<Pair> queue = new LinkedList<>();
    queue.add(new Pair(root, 0));

    while (!queue.isEmpty()) {
      Pair temp = queue.poll();
      int hd = temp.hd;
      Node node = temp.node;

      if (!map.containsKey(hd)) {
        map.put(hd, node.data);
      }

      if (node.left != null) {
        queue.add(new Pair(node.left, hd - 1));
      }

      if (node.right != null) {
        queue.add(new Pair(node.right, hd + 1));
      }
    }
    for (int value : map.values()) {
      System.out.print(value + " ");
    }

  }

  public static Node insert(Node root, int data) {
    if (root == null) {
      return new Node(data);
    } else {
      Node cur;
      if (data <= root.data) {
        cur = insert(root.left, data);
        root.left = cur;
      } else {
        cur = insert(root.right, data);
        root.right = cur;
      }
      return root;
    }
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    Node root = null;
    while (t-- > 0) {
      int data = scan.nextInt();
      root = insert(root, data);
    }
    scan.close();
    topView(root);
  }
}