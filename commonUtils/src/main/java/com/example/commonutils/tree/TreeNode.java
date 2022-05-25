package com.example.commonutils.tree;


import java.util.List;

/**
 * @author yaozx
 */
public interface TreeNode<T> {
    /**
     * id
     * @return
     */
    Long getId();

    /**
     * 排序
     * @return
     */
    Integer getSort();

    /**
     * 父级 id
     * @return
     */
    Long getParentId();

    /**
     * 子结点
     * @param list
     */
    void setChildren(List<T> list);
}
