//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。 
//
// 返回被除数 dividend 除以除数 divisor 得到的商。 
//
// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2 
//
// 
//
// 示例 1: 
//
// 输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = truncate(3.33333..) = truncate(3) = 3 
//
// 示例 2: 
//
// 输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = truncate(-2.33333..) = -2 
//
// 
//
// 提示： 
//
// 
// 被除数和除数均为 32 位有符号整数。 
// 除数不为 0。 
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。 
// 
// Related Topics 数学 二分查找 
// 👍 532 👎 0

package leetcode.editor.cn;
//Java：两数相除
public class DivideTwoIntegers{
    public static void main(String[] args) {
        Solution solution = new DivideTwoIntegers().new Solution();
        // TO TEST
        solution.divide(-2147483648,-1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 二分法
     */
    class Solution {
    public int divide(int dividend, int divisor) {
        long x = dividend,y=divisor;
        boolean flag = false;
        if((x>0 && y<0) || (x<0 && y>0)){ flag = true; }
        if(x <0){ x = -x; }
        if(y<0){ y=-y; }
        long l = 0,r=x;
        while(l<r){
            long mid = l+r+1>>1;
            if (mul(y,mid)<=x){
                l = mid;
            }else{
                r = mid-1;
            }
        }
        long ans = flag?-l:l;
        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {return Integer.MAX_VALUE;}
        return (int)ans;
    }

    public long mul(long a,long b){
        /*long res = 0;
        while(b>0){
            res += a;
            b -= 1;
        }
        return res;*/
        long ans = 0;
        while (b > 0) {
            if ((b & 1) == 1) {ans += a;}
            b >>= 1;
            a += a;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}