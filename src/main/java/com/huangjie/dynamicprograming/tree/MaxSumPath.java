package com.huangjie.dynamicprograming.tree;

import com.huangjie.tree.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangjie
 * @version 1.0
 * @description
 * @date 2021/7/6 10:20
 */
public class MaxSumPath {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(9);
        TreeNode root2 = new TreeNode(6);
        TreeNode root3 = new TreeNode(-3);
        TreeNode root4 = new TreeNode(-6);
        TreeNode root5 = new TreeNode(2);

        TreeNode root55 = new TreeNode(2);
        TreeNode root51 = new TreeNode(-6);
        TreeNode root52 = new TreeNode(-6);
        TreeNode root53 = new TreeNode(-6);
        root1.left = root2;
        root1.right = root3;
        root3.left = root4;
        root3.right = root5;
        root5.right = root55;
        root55.left = root52;
        root55.right = root53;


        TreeNode test1 = new TreeNode(-2);
        TreeNode test2 = new TreeNode(-1);

        test1.left = test2;

        System.out.println(maxPathSum(test1));
    }

    public static int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        List<Info> infos = new ArrayList<Info>();
        dp(root, infos);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < infos.size(); i++) {
            max = Math.max(max, infos.get(i).rootSum);
            max = Math.max(max, infos.get(i).leftRootSum);
            max = Math.max(max, infos.get(i).rightRootSum);
            max = Math.max(max, infos.get(i).leftSum);
            max = Math.max(max, infos.get(i).rightSum);
            max = Math.max(max, infos.get(i).nodeVal);
            System.out.println(infos.get(i));
        }
        return max;
    }

    /**
     * 递归生成每个节点的info信息
     *
     * @param node 头节点
     * @param list 收集Info信息的集合
     * @return 返回每个节点的info信息
     */
    public static Info dp(TreeNode node, List<Info> list) {
        if (node == null) {
            return null;
        }
        Info leftInfo = node.left != null ? dp(node.left, list)
                : null;
        Info rightInfo = node.right != null ? dp(node.right, list)
                : null;

        int rootSum = (leftInfo != null ? Math.max(leftInfo.leftRootSum, leftInfo.rightRootSum) : 0) +
                (rightInfo != null ? Math.max(rightInfo.leftRootSum, rightInfo.rightRootSum) : 0) + node.val;

        int leftSum = leftInfo == null ? node.val : Math.max(leftInfo.leftRootSum, leftInfo.rightRootSum);

        int rightSum = rightInfo == null ? node.val : Math.max(rightInfo.leftRootSum, rightInfo.rightRootSum);

        int leftRootSum = leftInfo == null ? node.val : Math.max(leftSum, 0) + node.val;

        int rightRootSum = rightInfo == null ? node.val : Math.max(rightSum, 0) + node.val;

        Info result = new Info(rootSum, leftSum, rightSum, leftRootSum, rightRootSum, node.val);
        list.add(result);
        return result;
    }

    /**
     * 每个节点包含的信息
     */
    public static class Info {

        public Info(int rootSum, int leftSum, int rightSum, int leftRootSum, int rightRootSum, int nodeVal) {
            this.nodeVal = nodeVal;
            this.rootSum = rootSum;
            this.leftSum = leftSum;
            this.rightSum = rightSum;
            this.leftRootSum = leftRootSum;
            this.rightRootSum = rightRootSum;
        }

        public int nodeVal;

        /**
         * 包含当前节点的最大路径和
         */
        public int rootSum;

        /**
         * 左子树的额最大路径和
         */
        public int leftSum;

        /**
         * 右子树的最大路径和
         */
        public int rightSum;

        /**
         * 经过头结点左子树的最大路径和
         */
        public int leftRootSum;

        /**
         * 经过头结点右子树的最大路径和
         */
        public int rightRootSum;

        @Override
        public String toString() {
            return "Info{" +
                    "nodeVal=" + nodeVal +
                    ", rootSum=" + rootSum +
                    ", leftSum=" + leftSum +
                    ", rightSum=" + rightSum +
                    ", leftRootSum=" + leftRootSum +
                    ", rightRootSum=" + rightRootSum +
                    '}';
        }
    }


}
