package com.huangjie.tree.service.orderscan;

import com.huangjie.tree.bean.TreeNode;

import java.util.List;

/**
 * @author huangjie
 * @version 1.0
 * @description 94. 二叉树的中序遍历
 * @date 2021/7/1 16:35
 */
public class InOrder {
    public static void main(String[] args) {

    }

    public static void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }


}
