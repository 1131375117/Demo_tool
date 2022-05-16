package com.hua.algorithm.leecode;

import com.hua.tulingxueyuan.tree.TreeNode;

/**
 * @author fuhua
 *
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 **/
public class Leecode_226 {

    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return root;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        return root;
    }
}
