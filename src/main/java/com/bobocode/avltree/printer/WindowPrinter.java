package com.bobocode.avltree.printer;

import com.bobocode.avltree.Node;
import javax.swing.JFrame;

public class WindowPrinter implements Printer {

  public void print(Node root) {
    // Create a Swing frame to display the binary tree
    JFrame frame = new JFrame("Binary Tree Visualization");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new TreePanel(root));
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}