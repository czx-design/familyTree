package Interface;

import family.treeNode;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

public class treeDrawer extends JFrame {
    int totalLevel = 0;
    int leftpadding = Integer.MAX_VALUE;

    public treeDrawer(treeNode tn) throws IOException {
        this.printTree(tn, "家谱");
        this.setLayeredPane(getLayeredPane());
        this.setBackground(null);
        this.setTitle("家谱");
        this.setSize(600,700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);        //退出设置
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.repaint();
        this.validate();
    }


    public void printTree(treeNode root, String name) throws IOException {

        totalLevel = getTotalLevel(root) - 1;
        BufferedImage bi = new BufferedImage(600, 700, BufferedImage.TYPE_INT_BGR);
        Graphics2D g = bi.createGraphics();
        g.setBackground(Color.cyan);
        g.setColor(Color.blue);
        ArrayList<treeNode> q = new ArrayList<treeNode>();
        q.add(root);
        BFSAndPaint(g, q, 0, false);
        bi = new BufferedImage(600, 700, BufferedImage.TYPE_INT_BGR);
        g = bi.createGraphics();
        BFSAndPaint(g, q, 0, true);
        this.leftpadding = Integer.MAX_VALUE;
        super.paint(g);

    }

    public void BFSAndPaint(Graphics2D g, ArrayList<treeNode> l, int level, boolean repaint) {
        ArrayList<treeNode> buff = new ArrayList<treeNode>();
        for (int i = 0; i < l.size(); i++) {
            treeNode current = l.get(i);
            GraphicNode gnode = null;
            if (null != current) {
                gnode = new GraphicNode(level, i, totalLevel);
                int gnodeX = gnode.getPoint(repaint).x;
                int gnodeY = gnode.getPoint(repaint).y;
                g.drawString(current.getName() + "", gnodeX, gnodeY);
                if (gnodeX < leftpadding && !repaint) {
                    leftpadding = gnodeX;
                }
                if (null != current.getLeft()) {
                    int leftIndex = i * 2;
                    GraphicNode gnode_left = new GraphicNode(level + 1, leftIndex, totalLevel);
                    g.drawLine(gnodeX + 5, gnodeY, gnode_left.getPoint(repaint).x + 5, gnode_left.getPoint(repaint).y - 10);
                }
                buff.add(current.getLeft());
                if (null != current.getRight()) {
                    int rightIndex = i * 2 + 1;
                    GraphicNode gnode_right = new GraphicNode(level + 1, rightIndex, totalLevel);
                    g.drawLine(gnodeX + 5, gnodeY, gnode_right.getPoint(repaint).x + 5, gnode_right.getPoint(repaint).y - 10);
                }
                buff.add(current.getRight());
            } else {
                buff.add(null);
                buff.add(null);
            }
        }
        if (isBuffEmpty(buff)) {
            return;
        } else {
            BFSAndPaint(g, buff, level + 1, repaint);
        }
    }


    private boolean isBuffEmpty(List<treeNode> list) {
        boolean ret = true;
        for (treeNode node : list) {
            if (null != node)
                ret = false;
        }
        return ret;
    }

    //获取二叉树的最大高度
    private int getTotalLevel(treeNode node) {
        if (null == node) {
            return 0;
        }
        return Math.max(getTotalLevel(node.getLeft()), getTotalLevel(node.getRight())) + 1;
    }

    private class GraphicNode {
        private Point p;
        private int level;
        private int index;
        public static final int LOWEST_PADDING = 20;        // 最小边距20
        public static final int LEVEL_PADDING = 30;     //不同层之间的间距
        private int totalLevel;

        public GraphicNode(int level, int index, int totalLevel) {          //tota和level同高
            this.level = level;
            this.index = index;
            this.totalLevel = totalLevel;
            this.p = computeP(this.level, this.index);
        }

        private Point computeP(int level, int index) {
            int x = 0;
            for (int i = this.totalLevel; i > level; i--) {
                x += getLevelPadding(i) / 2;
            }
            x += getLevelPadding(level) * index;
            int y = LEVEL_PADDING * (level + 1);
            return new Point(x, y);
        }

        public Point getPoint(boolean repaint) {
            if (repaint) {
                return new Point(p.x - leftpadding, p.y);
            }
            return p;
        }

        private int getLevelPadding(int level) {
            return (int) (LOWEST_PADDING * Math.pow(2, this.totalLevel - level));
        }
    }

    private class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }
    }


}

