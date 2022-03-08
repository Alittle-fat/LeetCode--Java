//字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数
//将返回左旋转两位得到的结果"cdefgab"。 
//
// 
//
// 示例 1： 
//
// 输入: s = "abcdefg", k = 2
//输出: "cdefgab"
// 
//
// 示例 2： 
//
// 输入: s = "lrloseumgh", k = 6
//输出: "umghlrlose"
// 
//
// 
//
// 限制： 
//
// 
// 1 <= k < s.length <= 10000 
// 
// Related Topics 字符串 
// 👍 127 👎 0

package leetcode.editor.cn;
//Java：左旋转字符串
public class ZuoXuanZhuanZiFuChuanLcof{
    public static void main(String[] args) {
        Solution solution = new ZuoXuanZhuanZiFuChuanLcof().new Solution();
        // TO TEST
    }

    /**
     * 可以截取拼接
     * 也可以用三次反转
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseLeftWords(String s, int n) {
        //return s.substring(n)+s.substring(0,n);
        int length = s.length();
        char[] chars = s.toCharArray();
        reverse(chars, 0, length - 1);//先反转全部的元素
        reverse(chars, 0, length - n - 1);//在反转前length - n个元素
        reverse(chars, length - n, length - 1);//接着反转剩余的
        return new String(chars);

    }
        private void reverse(char[] chars, int start, int end) {
            while (start < end) {
                char temp = chars[start];
                chars[start++] = chars[end];
                chars[end--] = temp;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}