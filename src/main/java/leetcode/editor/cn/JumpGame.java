//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// 0 <= nums[i] <= 105 
// 
// Related Topics 贪心算法 数组 
// 👍 1030 👎 0

package leetcode.editor.cn;
//Java：跳跃游戏
public class JumpGame{
    public static void main(String[] args) {
        Solution solution = new JumpGame().new Solution();
        // TO TEST
        solution.canJump(new int[]{3,0,8,2,0,0,1});
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
    public boolean canJump(int[] nums) {
        //维护一个最远可到达的位置,如果该位置大于数组的]=最后一个元素,则返回true
        int length = nums.length;
        int maxLength = nums[0];
        for (int i=0;i<length;++i){
            if (maxLength>=length-1){
                return true;
            }
            if (i>maxLength){
                return false;
            }else{
                maxLength = Math.max((i + nums[i]),maxLength);
            }
        }
        return false;
    }

        /**
         * 思路正确,但是超时了
         */
    /*public boolean find(int[] nums,int index, int targetIndex){
        if (index == targetIndex){
            return true;
        }
        if (nums[index] == 0){
            return false;
        }
        for (int i=1;i<=nums[index];++i){
            if (find(nums,index+i,targetIndex)){
                return true;
            }
        }
        return false;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}