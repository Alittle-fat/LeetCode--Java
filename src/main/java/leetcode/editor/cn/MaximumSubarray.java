//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2680 👎 0

package leetcode.editor.cn;
//Java：最大子序和
public class MaximumSubarray{
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
        // TO TEST
        solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
    public int maxSubArray(int[] nums) {
        //移动窗口法
        int max = Integer.MIN_VALUE;
        int i = 0,j=0,sum=0;
        for(int x=0;x<nums.length;++x){
            sum += nums[x];
            max = Math.max(max,sum);
            if (sum>0){
                ++j;
            }else{
                i=x+1;
                j=x+1;
                sum = 0;
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}