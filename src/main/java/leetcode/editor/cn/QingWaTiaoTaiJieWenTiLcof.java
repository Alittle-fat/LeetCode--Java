//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 示例 1： 
//
// 输入：n = 2
//输出：2
// 
//
// 示例 2： 
//
// 输入：n = 7
//输出：21
// 
//
// 示例 3： 
//
// 输入：n = 0
//输出：1 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
//
// 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/ 
//
// 
// Related Topics 递归 
// 👍 169 👎 0

package leetcode.editor.cn;
//Java：青蛙跳台阶问题
public class QingWaTiaoTaiJieWenTiLcof{
    public static void main(String[] args) {
        Solution solution = new QingWaTiaoTaiJieWenTiLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 与斐波那契数相似
     */
    class Solution {
    public int numWays(int n) {
        int a = 1,b=2;
        if (n<2){
            return a;
        }
        if(n==2){
            return b;
        }
        while(n>2){
            int temp = (a+b)%1000000007;
            a = b;
            b= temp;
            --n;
        }
        return b;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}