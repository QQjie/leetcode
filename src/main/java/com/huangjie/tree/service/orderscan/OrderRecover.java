package com.huangjie.tree.service.orderscan;

import com.huangjie.tree.bean.TreeNode;

import java.util.List;

/**
 * @author huangjie
 * @version 1.0
 * @description
 * @date 2021/7/1 17:01
 */
public class OrderRecover {
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
