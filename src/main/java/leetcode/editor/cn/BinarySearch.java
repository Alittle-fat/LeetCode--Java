//给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否
//则返回 -1。 
//
// 
//示例 1: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4
// 
//
// 示例 2: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 2
//输出: -1
//解释: 2 不存在 nums 中因此返回 -1
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设 nums 中的所有元素是不重复的。 
// n 将在 [1, 10000]之间。 
// nums 的每个元素都将在 [-9999, 9999]之间。 
// 
// Related Topics 二分查找 
// 👍 161 👎 0

package leetcode.editor.cn;
//Java：二分查找
public class BinarySearch{
    public static void main(String[] args) {
        Solution solution = new BinarySearch().new Solution();
        // TO TEST
        int[] nums = {-1,0,3,5,9,12};
        int x = solution.search(nums,6);
        System.out.println(x);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
    public int search(int[] nums, int target) {
        if (null == nums || nums.length == 0){
            return -1;
        }
        return help(nums,0,nums.length-1,target);
    }

    private int help(int[] nums,int left,int right,int target){
        if (nums[left] == target){
            return left;
        }
        if (nums[right] == target){
            return right;
        }
        int mid = (left + right) >> 1;
        if (mid == left){
            return -1;
        }
        return nums[mid] > target ? help(nums, left, mid, target) : help(nums, mid, right, target);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}