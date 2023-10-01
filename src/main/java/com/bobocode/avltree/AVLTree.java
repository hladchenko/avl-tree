package com.bobocode.avltree;

public class AVLTree {

  public Node root;

  public Node insert(int value) {
    this.root = insert(this.root, value);
    return root;
  }

  private Node insert(Node node, int value) {
    var newNode = new Node(value);
    if (this.root == null) {
      this.root = new Node(value);
      node = this.root;
    } else if (newNode.value < node.value) {
      if (node.left == null) {
        node.left = newNode;
      } else {
        insert(node.left, value);
      }
    } else if (newNode.value > node.value) {
      if (node.right == null) {
        node.right = newNode;
      } else {
        insert(node.right, value);
      }
    }
    calculateHeight(node);

    var balance = calculateBalance(node);

    if (balance > 1) {
      return rightRotate(node);
    } else if (balance < -1) {
      return leftRotate(node);
    }
    return node;
  }

  private Node leftRotate(Node node) {
    System.out.println("leftRotate: " + node.value);
    var parentNode = node;
    var child = node.right;

    if (parentNode.left == null) {
      parentNode.left = new Node(parentNode.value);
      parentNode.value = child.value;
      parentNode.height = child.height;
      parentNode.right = child.right;
    } else {
      var leftSubTree = parentNode.left;
      parentNode.left = new Node(parentNode.value);
      parentNode.left.left = leftSubTree;
      parentNode.value = child.value;
      parentNode.height = child.height;
      parentNode.right = child.right;
    }
    return node;
  }

  private Node rightRotate(Node node) {
    System.out.println("rightRotate");
    return node;
  }

  private void calculateHeight(Node node) {
    if (node.left == null && node.right == null) {
      node.height = 0;
    } else if (node.left == null) {
      node.height = 1 + node.right.height;
    } else if (node.right == null) {
      node.height = 1 + node.left.height;
    } else {
      node.height = 1 + Math.max(node.left.height, node.right.height);
    }
  }

  private int calculateBalance(Node node) {
    if (node.left == null && node.right == null) {
      return 0;
    } else if (node.left == null) {
      return -1 - node.right.height;
    } else if (node.right == null) {
      return node.left.height + 1;
    } else {
      return node.left.height - node.right.height;
    }
  }

  public int height() {
    return root.height;
  }
}
