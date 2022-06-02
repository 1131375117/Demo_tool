package com.hua.algorithm.leecode;

import com.hua.tulingxueyuan.tree.TreeNode;

/**
 * @author fuhua
 * <p>
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 **/
//todo 付华
public class Leecode_110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return deepTree(root) != -1;
    }

    private int deepTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = deepTree(root.left);
        int r = deepTree(root.right);
        if (l  == -1 || r  == - 1 || Math.abs(l - r) > 1) {
            return -1;
        }
        return Math.max(l, r) + 1;
    }
}
