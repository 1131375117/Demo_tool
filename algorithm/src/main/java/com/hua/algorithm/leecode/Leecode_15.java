package com.hua.algorithm.leecode;

import javax.swing.text.TabableView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fuhua
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Leecode_15 {

    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(Arrays.toString(new List[]{lists}));
    }


    /**
     * 排序+双指针
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        if (n < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) break;
            int head = i + 1, tail = n - 1;
            while (head < tail) {
                if (nums[i] + nums[head] + nums[tail] < 0) {
                    head++;
                } else if (nums[i] + nums[head] + nums[tail] > 0) {
                    tail--;
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i] );
                    list.add(nums[head] );
                    list.add(nums[tail]);
                    result.add(list);
                    //去重
                    while (head < tail && nums[head] == nums[head+1]) head++;
                    while (head < tail && nums[tail] == nums[tail-1]) tail--;
                    head++;
                    tail--;
                }
            }
            while (i + 1 < n && nums[i] == nums[i+1]) i++;
        }
        return result;
    }
}
