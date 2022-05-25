package com.hua.algorithm.leecode;

/**
 * @author fuhua
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 返回容器可以储存的最大水量。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Leecode_11 {

    public static void main(String[] args) {
        int i = maxArea(new int[]{1, 2, 3, 4, 5, 6});
    }

    /**
     * 解法思路：双指针
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int max = 0;
        int l = 0;//最右边指针
        int r = height.length - 1;//最左边指针
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            max = Math.max(max, area);

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
