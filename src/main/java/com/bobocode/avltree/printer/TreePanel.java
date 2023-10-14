package com.bobocode.avltree.printer;

import com.bobocode.avltree.Node;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;

class TreePanel extends JPanel {

  private Node root;
  private int nodeRadius = 20;
  private int horizontalSpacing = 150; // Adjust this value as needed
  private int verticalSpacing = 70; // Adjust this value as needed

  TreePanel(Node root) {
    this.root = root;
    setPreferredSize(new Dimension(800, 600));
  }

  private void drawNode(Graphics2D g2, Node node, int x, int y, int xOffset, int yOffset) {
    if (node == null) {
      return;
    }

    g2.setColor(Color.BLACK);
    g2.fill(new Ellipse2D.Double(x - nodeRadius, y - nodeRadius, 2 * nodeRadius, 2 * nodeRadius));
    g2.setColor(Color.WHITE);
    g2.drawString(String.valueOf(node.value), x - 5, y + 5);

    if (node.left != null) {
      g2.setColor(Color.BLACK);
      g2.drawLine(x, y, x - xOffset, y + yOffset);
      drawNode(g2, node.left, x - xOffset, y + yOffset, xOffset / 2, yOffset);
    }

    if (node.right != null) {
      g2.setColor(Color.BLACK);
      g2.drawLine(x, y, x + xOffset, y + yOffset);
      drawNode(g2, node.right, x + xOffset, y + yOffset, xOffset / 2, yOffset);
    }
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    int startX = getWidth() / 2;
    int startY = 30;

    drawNode(g2, root, startX, startY, horizontalSpacing, verticalSpacing);
  }
}
