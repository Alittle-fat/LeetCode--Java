//给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回
// 0。 
//
// 
//
// 示例： 
//
// 输入：s = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。 
// 
// Related Topics 数组 双指针 二分查找 
// 👍 474 👎 0

package leetcode.editor.cn;
//Java：长度最小的子数组
public class MinimumSizeSubarraySum{
    public static void main(String[] args) {
        Solution solution = new MinimumSizeSubarraySum().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        //移动窗口法
        //定义另个指针lr,分别表示窗口的左右边界,刚开始r右移,当窗口内数的和刚大于s时停止,记录此时的长度
        //然后l右移动,直到第一次小于等于s(等于s时记录此时的长度),然后返回第一步,如此重复
        if(null == nums || nums.length == 0){
            return 0;
        }
        //设置初始值
        int left = 0,right = 0,sum = 0,length = Integer.MAX_VALUE;
        while(right<nums.length){
            sum += nums[right++];
            while(sum>=s){
                length = Math.min(length, right - left);
                if (length == 1){
                    return 1;
                }
                sum -= nums[left];
                ++left;
            }
        }
        return length == Integer.MAX_VALUE ? 0 : length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}