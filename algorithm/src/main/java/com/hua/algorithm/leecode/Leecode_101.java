package com.hua.algorithm.leecode;

import com.hua.tulingxueyuan.tree.TreeNode;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 * @author fuhua
 **/
public class Leecode_101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        //递归调用函数
        return resCheck(root.left, root.right);
    }

    private boolean resCheck(TreeNode left, TreeNode right) {
        //递归调用终止条件
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if(left.val!=right.val){
            return false;
        }
        return resCheck(left.left,right.right)&&resCheck(left.right,right.left);
    }

}
