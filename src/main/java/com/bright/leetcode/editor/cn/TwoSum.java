//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表 
// 👍 9739 👎 0

package com.bright.leetcode.editor.cn;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        /**
         * 解题思路一
         * 通过穷举遍历数组，获取两个数字x，y，满足x + y = target 且 x的索引位置大于y的索引位置，这样能避免重复计算
         * @param nums 源数组
         * @param target 目标值
         * @return 新数组，包含满足条件的元素下标值
         */
        public int[] twoSum(int[] nums, int target) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j <  n; j++) {
                    System.out.println(j);
                    int sum = nums[i] + nums[j];
                    if (sum == target) {
                        return new int[]{i,j};
                    }
                }
            }
            return new int[0];
        }

        /**
         *
         * @param nums
         * @param target
         * @return
         */
        public int[] twoSum2(int[] nums, int target) {

            return new int[0];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
