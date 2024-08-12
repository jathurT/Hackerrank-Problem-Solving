package Level_Order_Traversal;

import java.util.*;

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

  /*

    class Node
      int data;
      Node left;
      Node right;
  */
  public static void levelOrder(Node root) {
    if (root == null)
      return;
    Queue<Node> queue = new LinkedList<>();
    List<Node> levelOrder = new ArrayList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      Node temp = queue.poll();
      levelOrder.add(temp);
      if (temp.left != null) {
        queue.add(temp.left);
      }
      if (temp.right != null) {
        queue.add(temp.right);
      }
    }
    for (Node node : levelOrder) {
      System.out.print(node.data + " ");
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
    levelOrder(root);
  }
}