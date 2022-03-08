//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。 
//
// 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//输出: 2 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/ 
//
// 
// Related Topics 位运算 分治算法 
// 👍 165 👎 0

package leetcode.editor.cn;
//Java：数组中出现次数超过一半的数字
public class ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof{
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 摩尔投票法
     */
    class Solution {
    public int majorityElement(int[] nums) {
        //x表示众数,votes表示投票数
        int x = 0, votes = 0;
        for(int num : nums){
            if(votes == 0){
                //投票数为0,则前面的可以忽略,默认当前的最新元素为众数
                x = num;
            }
            //与当前众数相等,则为1,不等则为-1
            votes += num == x ? 1 : -1;
        }
        return x;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}