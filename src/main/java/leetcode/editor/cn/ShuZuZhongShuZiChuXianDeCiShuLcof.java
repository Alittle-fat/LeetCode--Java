//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,1,4,6]
//输出：[1,6] 或 [6,1]
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,10,4,1,4,3,3]
//输出：[2,10] 或 [10,2] 
//
// 
//
// 限制： 
//
// 
// 2 <= nums.length <= 10000 
// 
//
// 
// Related Topics 位运算 数组 
// 👍 412 👎 0

package leetcode.editor.cn;
//Java：数组中数字出现的次数
public class ShuZuZhongShuZiChuXianDeCiShuLcof{
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongShuZiChuXianDeCiShuLcof().new Solution();
        // TO TEST
        solution.singleNumbers(new int[]{4,1,4,6});
    }

    /**
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] singleNumbers(int[] nums) {
        int x = 0, y = 0, n = 0, m = 1;
        for (int num : nums) {               // 1. 遍历异或
            n ^= num;
        }
        //此时的n为两个只出现一次的数的亦或值
        while ((n & m) == 0) {               // 2. 循环左移，计算 m
            //从低向高找到n中第一个值为1的位置
            m <<= 1;
        }
        //m位置x和y是不等的,故可以依次将x和y分别分到两个组中,每个组的亦或者最后肯定是x或y
        for (int num : nums) {              // 3. 遍历 nums 分组
            if ((num & m) != 0) {
                // 4. 当 num & m != 0
                x ^= num;
            }else {
                y ^= num;
            }
        }
        return new int[] { x, y };          // 5. 返回出现一次的数字
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}