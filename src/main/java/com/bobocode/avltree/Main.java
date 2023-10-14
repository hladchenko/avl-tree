package com.bobocode.avltree;

import com.bobocode.avltree.printer.ConsolePrinter;
import com.bobocode.avltree.printer.Printer;
import com.bobocode.avltree.printer.WindowPrinter;

public class Main {

  public static void main(String[] args) {
    AVLTree avlTree = new AVLTree();
    for (int i = 0; i < 10; i++) {
      avlTree.insert(i);
    }


    Printer printer = new WindowPrinter();
    Printer consolePrinter = new ConsolePrinter();
    consolePrinter.print(avlTree.root);
    printer.print(avlTree.root);
  }
}