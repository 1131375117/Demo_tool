package com.example.commonutils.tree;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * @author yaozx
 */
@Slf4j
public class TreeUtils {
    /**
     * 创建树结构
     */
    public static <T extends TreeNode<T>> List<T> treeFormat(List<T> treeList) {
        List<T> rootNodes = new ArrayList<>();
        Iterator<T> it = treeList.iterator();
        while (it.hasNext()) {
            T next = it.next();
            //parent（上级Id）为0的是根节点
            if (0 == next.getParentId()) {
                rootNodes.add(next);
                it.remove();
            }
        }
        rootNodes.sort(Comparator.comparingInt(T::getSort));
        //遍历，找到二级节点
        for (TreeNode<T> node : rootNodes) {
            List<T> child = getChild(treeList, node.getId());
            node.setChildren(child);
        }
        return rootNodes;
    }

    /**
     * 查子节点
     */
    private static <T extends TreeNode<T>> List<T> getChild(List<T> treeList, Long parentId) {
        //子节点列表
        List<T> childList = new ArrayList<>();
        Iterator<T> it = treeList.iterator();
        while (it.hasNext()) {
            T node = it.next();
            if (parentId.equals(node.getParentId())) {
                childList.add(node);
                it.remove();
            }
        }
        childList.sort(Comparator.comparingInt(T::getSort));
        for (T node : childList) {
            List<T> child = getChild(treeList, node.getId());
            node.setChildren(child);
        }
        //递归出口
        if (childList.size() == 0) {
            return new ArrayList<>();
        }
        return childList;
    }

}
