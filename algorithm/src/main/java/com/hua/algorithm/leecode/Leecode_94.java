package com.hua.algorithm.leecode;

import com.hua.tulingxueyuan.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fuhua
 * <p>
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Leecode_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        selectNode(root, res);
        return res;
    }

    private void selectNode(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }
        selectNode(root.left, res);
        res.add(root.val);
        selectNode(root.right, res);
    }
}
