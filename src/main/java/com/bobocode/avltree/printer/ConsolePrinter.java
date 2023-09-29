package com.bobocode.avltree.printer;

import com.bobocode.avltree.Node;
import java.util.LinkedList;

public class ConsolePrinter implements Printer {

  public static void printSpace(double n, Node removed) {
    for (; n > 0; n--) {
      System.out.print("\t");
    }
    if (removed == null) {
      System.out.print(" ");
    } else {
      System.out.print(removed.value);
    }
  }

  @Override
  public void print(Node root) {
    LinkedList<Node> treeLevel = new LinkedList<Node>();
    treeLevel.add(root);
    LinkedList<Node> temp = new LinkedList<Node>();
    int counter = 0;
    int height = root.height;
    // System.out.println(height);
    double numberOfElements
        = (Math.pow(2, (height + 1)) - 1);
    // System.out.println(numberOfElements);
    while (counter <= height) {
      Node removed = treeLevel.removeFirst();
      if (temp.isEmpty()) {
        printSpace(numberOfElements
                / Math.pow(2, counter + 1),
            removed);
      } else {
        printSpace(numberOfElements
                / Math.pow(2, counter),
            removed);
      }
      if (removed == null) {
        temp.add(null);
        temp.add(null);
      } else {
        temp.add(removed.left);
        temp.add(removed.right);
      }

      if (treeLevel.isEmpty()) {
        System.out.println("");
        System.out.println("");
        treeLevel = temp;
        temp = new LinkedList<>();
        counter++;
      }
    }
  }
}
