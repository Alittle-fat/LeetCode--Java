//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学 
// 👍 2355 👎 0

package leetcode.editor.cn;
//Java：整数反转
public class ReverseInteger{
    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
        // TO TEST
        int x = solution.reverse(123);
        System.out.println(x);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
    public int reverse(int x) {
        //我们用数学方法,每次对10取余运算,获取最低位
        int res = 0;
        while(x != 0){
            int tmp = x%10;
            //判断是否 大于 最大32位整数
            //max = 214748364
            int max = (int)(Math.pow(2,31)-1)/10;
            if (res>max || (res==max && tmp>7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (res<-max || (res==-max && tmp<-8)) {
                return 0;
            }
            res = res *10 +tmp;
            x /=10;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    //可以使可以,但是会溢出
    /*
    public int reverse(int x) {
        if (x<0){
            return -reverse(-x);
        }
        String string = String.valueOf(x);
        char[] s = string.toCharArray();

        //字符串反转
        int l=0,r=s.length-1;
        while(l<r){
            s[l] ^= s[r];
            s[r] ^= s[l];
            s[l] ^= s[r];
            ++l;
            --r;
        }
        return Integer.valueOf(new String(s));
    }
     */
}