package com.hua.algorithm.leecode;

import com.hua.tulingxueyuan.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author fuhua
 **/
public class Leecode_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new LinkedList<>();
         foreach(results, root, 0);
        return results;
    }

    private void foreach (List<List<Integer>> results, TreeNode root, int high) {
        if (root == null)
            return ;
        if(high==results.size())
        results.add(new LinkedList<>());
        List<Integer> list = results.get(high);
        list.add(root.val);
        foreach(results, root.left, high + 1);
        foreach(results, root.right, high + 1);
        return ;
    }
}
