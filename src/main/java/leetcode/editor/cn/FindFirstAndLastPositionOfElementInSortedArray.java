//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 792 👎 0

package leetcode.editor.cn;
//Java：在排序数组中查找元素的第一个和最后一个位置
public class FindFirstAndLastPositionOfElementInSortedArray{
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        // TO TEST
        solution.searchRange(new int[]{5,7,7,8,8,10},6);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
    public int[] searchRange(int[] nums, int target) {
        //法1: 遍历
        int l=0,r=nums.length-1;
        while(l<nums.length && nums[l] < target){
            ++l;
        }
        while(r>=0 && nums[r]>target){
            --r;
        }
        return l>r?new int[]{-1,-1}:new int[]{l,r};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}