package com.bobocode.avltree;

public class AVLTree {

  public Node root;

  public Node insert(int value) {
    this.root = insert(this.root, value);
    return root;
  }

  private Node insert(Node node, int value) {
    var newNode = new Node(value);
    if (node == null) {
      return new Node(value);
    }
    if (newNode.value < node.value) {
      node.left = insert(node.left, value);
    } else if (newNode.value > node.value) {
      node.right = insert(node.right, value);
    }

    calculateHeight(node);
    var balance = calculateBalance(node);

    // LL rotation
    if (balance > 1 && value < node.left.value) {
      return rightRotate(node);
    }
    // RR rotation
    if (balance < -1 && value > node.right.value) {
      return leftRotate(node);
    }
    // LR rotation
    if (balance > 1 && value > node.left.value) {
      node.left = leftRotate(node.left);
      return rightRotate(node);
    }
    // RL rotation
    if (balance < -1 && value < node.right.value) {
      node.right = rightRotate(node.right);
      return leftRotate(node);
    }
    return node;
  }

  private Node leftRotate(Node subtreeRoot) {
    var child = subtreeRoot.right;

    subtreeRoot.right = child.left;
    calculateHeight(subtreeRoot);
    child.left = subtreeRoot;
    calculateHeight(child);

    return child;
  }

  private Node rightRotate(Node subtreeRoot) {
    var child = subtreeRoot.left;

    subtreeRoot.left = child.right;
    calculateHeight(subtreeRoot);
    child.right = subtreeRoot;
    calculateHeight(child);

    return child;
  }

  private int getHeight(Node node) {
    if (node == null) {
      return 0;
    }
    return node.height;
  }

  private void calculateHeight(Node node) {
    node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
  }

  private int calculateBalance(Node node) {
    return getHeight(node.left) - getHeight(node.right);
  }

  public int height() {
    return getHeight(root);
  }
}
