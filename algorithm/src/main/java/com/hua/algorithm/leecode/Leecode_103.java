package com.hua.algorithm.leecode;

import com.hua.tulingxueyuan.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fuhua
 **/
public class Leecode_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results=new ArrayList<>();
        foreach(results,root,0);
        return results;
    }

    private void foreach(List<List<Integer>> results, TreeNode root, int high) {
        if(root==null){
            return;
        }
        if(high>=results.size()){
            results.add(new ArrayList<>());
        }
        List<Integer> list = results.get(high);
        if(high%2!=0){
          list.add(root.val);
        }else{
           list.add(0,root.val);
        }
        foreach(results,root.right,high+1);
        foreach(results,root.left,high+1);
    }
}
