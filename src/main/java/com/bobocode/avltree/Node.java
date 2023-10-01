package com.bobocode.avltree;

public class Node {

  public Node left;
  public Node right;
  public int value;
  public int height;

  public Node(int value) {
    this.value = value;
    this.height = 1;
  }
}
