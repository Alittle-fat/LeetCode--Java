//从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任
//意数字。A 不能视为 14。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5]
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: [0,0,1,2,5]
//输出: True 
//
// 
//
// 限制： 
//
// 数组长度为 5 
//
// 数组的数取值为 [0, 13] . 
// 👍 139 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：扑克牌中的顺子
public class BuKePaiZhongDeShunZiLcof{
    public static void main(String[] args) {
        Solution solution = new BuKePaiZhongDeShunZiLcof().new Solution();
        // TO TEST
    }

    /**
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int joker = 0;
        for(int i=0;i<nums.length-1;++i){
            if (nums[i] == 0){
                ++joker;
            }else if(nums[i] == nums[i+1]){
                return false;
            }
        }
        //nums[joker]为第一个不为0的位置
        return nums[4]-nums[joker]<5;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}