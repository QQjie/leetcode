package com.huangjie.tree.bean;

import lombok.Data;

/**
 * @author huangjie
 * @version 1.0
 * @description
 * @date 2021/7/1 16:34
 */
@Data
public class TreeNode {
     public int val;
     public TreeNode left;
     public TreeNode right;
     TreeNode() {}
     public TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}
