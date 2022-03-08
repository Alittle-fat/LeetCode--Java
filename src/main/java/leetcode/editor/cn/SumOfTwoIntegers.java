//不使用运算符 + 和 - ，计算两整数 a 、b 之和。 
//
// 示例 1: 
//
// 输入: a = 1, b = 2
//输出: 3
// 
//
// 示例 2: 
//
// 输入: a = -2, b = 3
//输出: 1 
// Related Topics 位运算 
// 👍 376 👎 0

package leetcode.editor.cn;
//Java：两整数之和
public class SumOfTwoIntegers{
    public static void main(String[] args) {
        Solution solution = new SumOfTwoIntegers().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 将想加运算拆分,异或得到相加位置,与得到进制位置
     */
    class Solution {
    public int getSum(int a, int b) {
        while(b != 0){
            //a表示相加位,b表示进制位
            int temp = a^b;
            //注意要左移1位
            b = (a&b)<<1;
            a = temp;
        }
        //当进制为0的时候,相加位就是结果
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}