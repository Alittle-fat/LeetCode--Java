//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 
// 👍 141 👎 0

package leetcode.editor.cn;
//Java：在排序数组中查找数字 I
public class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof{
    public static void main(String[] args) {
        Solution solution = new ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
        // TO TEST
    }

    /**
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        int length = nums.length;
        if (length == 0 || nums[length-1] <target || nums[0]>target){
            return 0;
        }
        int l = 0,r = length -1;
        while(l<r && nums[l]<target){
            ++l;
        }
        while(l<r && nums[r]>target){
            --r;
        }
        return l==r && nums[l] != target ? 0: r-l+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}