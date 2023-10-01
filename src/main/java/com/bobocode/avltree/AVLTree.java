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
        node.left = insert(node.left, value);
      }
    } else if (newNode.value > node.value) {
      if (node.right == null) {
        node.right = newNode;
      } else {
        node.right = insert(node.right, value);
      }
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
