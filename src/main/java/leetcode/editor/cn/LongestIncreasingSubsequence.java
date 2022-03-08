//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序
//列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -104 <= nums[i] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以设计时间复杂度为 O(n2) 的解决方案吗？ 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// Related Topics 二分查找 动态规划 
// 👍 1305 👎 0

package leetcode.editor.cn;

import org.springframework.util.CollectionUtils;

//Java：最长递增子序列
public class LongestIncreasingSubsequence{
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
        // TO TEST
        solution.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
    public int lengthOfLIS(int[] nums) {
        //定义一个dp[i]表示前i个元素中的最大升序子序列,必须以nums[i]结尾
        //最终的结果为dp[i]中的最大值
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res =1;
        for (int i =1;i<nums.length;++i){
            int max = 1;
            for (int j=0;j<i;++j){
                if (nums[j]<nums[i]){
                    max = Math.max(dp[j]+1,max);
                }
            }
            dp[i] = max;
            res = Math.max(max,res);
        }
        return res;


        //另一种思路是维护一个数组dp[len],表示长度为length的最大子序列的最后一个元素,
        //不难证明,该元素是单调递增的
        //然后遍历nums,如果nums[i]>dp[len],那么就把dp[len+1] = nums[i]
        //否则,就更新dp[len],利用二分查找,确定nums[i]在dp[len]中的位置
        //代码如下
        /**
         int len = 1, n = nums.length;
         if (n == 0) {
         return 0;
         }
         int[] d = new int[n + 1];
         d[len] = nums[0];
         for (int i = 1; i < n; ++i) {
         if (nums[i] > d[len]) {
         d[++len] = nums[i];
         } else {
         int l = 1, r = len, pos = 0; // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
         while (l <= r) {
         int mid = (l + r) >> 1;
         if (d[mid] < nums[i]) {
         pos = mid;
         l = mid + 1;
         } else {
         r = mid - 1;
         }
         }
         d[pos + 1] = nums[i];
         }
         }
         return len;
         */
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}