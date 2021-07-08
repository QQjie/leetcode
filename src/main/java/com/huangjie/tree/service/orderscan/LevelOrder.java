package com.huangjie.tree.service.orderscan;

import com.huangjie.tree.bean.TreeNode;

import java.util.*;

/**
 * @author huangjie
 * @version 1.0
 * @description 102. 二叉树的层序遍历
 * @date 2021/7/2 15:45
 */
public class LevelOrder {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);

        TreeNode node2 = new TreeNode(20);
        root.left = node1;
        root.right = node2;


        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        node2.left = node3;
        node2.right = node4;

        List<List<Integer>> lists = levelOrder2(root);

        for (List<Integer> list : lists) {

            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + "--");
            }
            System.out.println("");
        }

        System.out.println(lists);

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        Deque<LevelNode> deque = new ArrayDeque<LevelNode>();
        levelOrder2(root, 0, deque);

        while (!deque.isEmpty()) {
            LevelNode levelNode = deque.pollFirst();
            if (list.size() < levelNode.level + 1) {
                List<Integer> nodeList = new ArrayList<Integer>();
                nodeList.add(levelNode.treeNode.getVal());
                list.add(nodeList);
            } else {
                list.get(levelNode.level).add(levelNode.treeNode.getVal());
            }
        }
        return list;
    }


    public static void levelOrder(TreeNode root, int level, Deque<LevelNode> deque) {
        if (root == null) {
            return;
        }
        deque.addLast(new LevelNode(level, root));
        if (root.left != null) {
            levelOrder(root.left, level + 1, deque);
        }
        if (root.right != null) {
            levelOrder(root.right, level + 1, deque);
        }
    }



    public static void levelOrder2(TreeNode root, int level, Deque<LevelNode> deque) {
        if (root == null) {
            return;
        }
        deque.addLast(new LevelNode(level, root));

        if ((1 & level) == 0) {
            if (root.right != null) {
                levelOrder2(root.right, level + 1, deque);
            }
            if (root.left != null) {
                levelOrder2(root.left, level + 1, deque);
            }
        }else{
            if (root.left != null) {
                levelOrder2(root.left, level + 1, deque);
            }
            if (root.right != null) {
                levelOrder2(root.right, level + 1, deque);
            }
        }


    }


    public static class LevelNode {
        public int level;
        public TreeNode treeNode;

        public LevelNode(int level, TreeNode treeNode) {
            this.level = level;
            this.treeNode = treeNode;
        }
    }


    public static List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        Deque<LevelNode> deque = new ArrayDeque<LevelNode>();

        deque.addLast(new LevelNode(0, root));

        while (!deque.isEmpty()) {
            LevelNode levelNode = deque.pollFirst();
            if (list.size() < levelNode.level + 1) {
                List<Integer> nodeList = new ArrayList<Integer>();
                nodeList.add(levelNode.treeNode.getVal());
                list.add(nodeList);
            } else {
                list.get(levelNode.level).add(levelNode.treeNode.getVal());
            }

            if ((levelNode.level&1)==0) {
                if (levelNode.treeNode.right!=null) {
                    deque.addLast(new LevelNode(levelNode.level+1,levelNode.treeNode.right));
                }
                if (levelNode.treeNode.left!=null) {
                    deque.addLast(new LevelNode(levelNode.level+1,levelNode.treeNode.left));
                }
            }else{
                if (levelNode.treeNode.left!=null) {
                    deque.addLast(new LevelNode(levelNode.level+1,levelNode.treeNode.left));
                }
                if (levelNode.treeNode.right!=null) {
                    deque.addLast(new LevelNode(levelNode.level+1,levelNode.treeNode.right));
                }
            }


        }
        return list;
    }


}
