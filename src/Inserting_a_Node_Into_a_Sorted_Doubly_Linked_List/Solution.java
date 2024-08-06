package Inserting_a_Node_Into_a_Sorted_Doubly_Linked_List;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

  static class DoublyLinkedListNode {
    public int data;
    public DoublyLinkedListNode next;
    public DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int nodeData) {
      this.data = nodeData;
      this.next = null;
      this.prev = null;
    }
  }

  static class DoublyLinkedList {
    public DoublyLinkedListNode head;
    public DoublyLinkedListNode tail;

    public DoublyLinkedList() {
      this.head = null;
      this.tail = null;
    }

    public void insertNode(int nodeData) {
      DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

      if (this.head == null) {
        this.head = node;
      } else {
        this.tail.next = node;
        node.prev = this.tail;
      }

      this.tail = node;
    }
  }

  public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
    while (node != null) {
      bufferedWriter.write(String.valueOf(node.data));

      node = node.next;

      if (node != null) {
        bufferedWriter.write(sep);
      }
    }
  }

  //  public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode llist, int data) {
//    // Write your code here
//    DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
//    if (llist == null) {
//      return newNode;
//    } else if (data <= llist.data) {
//      newNode.next = llist;
//      llist.prev = newNode;
//      return newNode;
//    } else {
//      DoublyLinkedListNode rest = sortedInsert(llist.next, data);
//      llist.next = rest;
//      rest.prev = llist;
//      return llist;
//    }
//  }

  public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode llist, int data) {
    DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);

    // Case 1: The list is empty
    if (llist == null) {
      return newNode;
    }

    // Case 2: Insert before the head
    if (data <= llist.data) {
      newNode.next = llist;
      llist.prev = newNode;
      return newNode;
    }

    // Traverse the list to find the insertion point
    DoublyLinkedListNode current = llist;
    while (current.next != null && current.next.data < data) {
      current = current.next;
    }

    // Insert the new node
    newNode.next = current.next;
    newNode.prev = current;

    if (current.next != null) {
      current.next.prev = newNode;
    }

    current.next = newNode;

    return llist;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int t = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int tItr = 0; tItr < t; tItr++) {
      DoublyLinkedList llist = new DoublyLinkedList();

      int llistCount = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < llistCount; i++) {
        int llistItem = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        llist.insertNode(llistItem);
      }

      int data = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      DoublyLinkedListNode llist1 = sortedInsert(llist.head, data);

      printDoublyLinkedList(llist1, " ", bufferedWriter);
      bufferedWriter.newLine();
    }

    bufferedWriter.close();

    scanner.close();
  }
}
