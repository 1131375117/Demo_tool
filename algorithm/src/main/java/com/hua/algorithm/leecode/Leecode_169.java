package com.hua.algorithm.leecode;

import com.hua.tulingxueyuan.tree.TreeNode;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fuhua
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Leecode_169 {
    public int majorityElement(int[] nums) {
        int count = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (max == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    max = nums[i+1];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
