//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 231 
// 
// Related Topics 字符串 动态规划 
// 👍 241 👎 0

package leetcode.editor.cn;
//Java：把数字翻译成字符串
public class BaShuZiFanYiChengZiFuChuanLcof{
    public static void main(String[] args) {
        Solution solution = new BaShuZiFanYiChengZiFuChuanLcof().new Solution();
        // TO TEST
    }

    /**
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int translateNum(int num) {
        return help(String.valueOf(num));
    }
    public int help(String num){
        int length = num.length();
        if (length == 0 || length == 1){
            return 1;
        }
        Integer pre = Integer.valueOf(num.substring(0,2));
        //一定要注意首位为0的情况
        if(pre >25 || pre<10){
            return help(num.substring(1));
        }else{
            return help(num.substring(1)) + help(num.substring(2));
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}