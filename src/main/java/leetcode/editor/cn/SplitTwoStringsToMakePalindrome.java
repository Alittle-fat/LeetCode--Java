//给你两个字符串 a 和 b ，它们长度相同。请你选择一个下标，将两个字符串都在 相同的下标 分割开。由 a 可以得到两个字符串： aprefix 和 asu
//ffix ，满足 a = aprefix + asuffix ，同理，由 b 可以得到两个字符串 bprefix 和 bsuffix ，满足 b = bpref
//ix + bsuffix 。请你判断 aprefix + bsuffix 或者 bprefix + asuffix 能否构成回文串。 
//
// 当你将一个字符串 s 分割成 sprefix 和 ssuffix 时， ssuffix 或者 sprefix 可以为空。比方说， s = "abc" 那么
// "" + "abc" ， "a" + "bc" ， "ab" + "c" 和 "abc" + "" 都是合法分割。 
//
// 如果 能构成回文字符串 ，那么请返回 true，否则返回 false 。 
//
// 请注意， x + y 表示连接字符串 x 和 y 。 
//
// 
//
// 示例 1： 
//
// 
//输入：a = "x", b = "y"
//输出：true
//解释：如果 a 或者 b 是回文串，那么答案一定为 true ，因为你可以如下分割：
//aprefix = "", asuffix = "x"
//bprefix = "", bsuffix = "y"
//那么 aprefix + bsuffix = "" + "y" = "y" 是回文串。
// 
//
// 示例 2： 
//
// 
//输入：a = "ulacfd", b = "jizalu"
//输出：true
//解释：在下标为 3 处分割：
//aprefix = "ula", asuffix = "cfd"
//bprefix = "jiz", bsuffix = "alu"
//那么 aprefix + bsuffix = "ula" + "alu" = "ulaalu" 是回文串。 
//
// 
//
// 提示： 
//
// 
// 1 <= a.length, b.length <= 105 
// a.length == b.length 
// a 和 b 都只包含小写英文字母 
// 
// Related Topics 贪心算法 双指针 字符串 
// 👍 15 👎 0

package leetcode.editor.cn;
//Java：分割两个字符串得到回文串
public class SplitTwoStringsToMakePalindrome{
    public static void main(String[] args) {
        Solution solution = new SplitTwoStringsToMakePalindrome().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
        public boolean checkPalindromeFormation(String a, String b) {
            return check(a,b)||check(b,a);
        }

        private boolean check(String a,String b){
            char[] stra = a.toCharArray();
            char[] strb = b.toCharArray();
            int left = 0;
            int length = stra.length;
            while (left<=length/2){
                if (stra[left]==strb[length-1-left]) {
                    left++;
                }
                else{
                    break;}
            }
            //如果超过一半都是相等的，直接返回true
            if (left>=length/2){
                return true;
            }
            //否则判断中间未遍历的部分是否是回文
            if (isPalindrome(a.substring(left,length-left)) || isPalindrome(b.substring(left,length-left))){
                return true;
            }
            return false;
        }

        public boolean isPalindrome(String s) {
            char[] str  =s.toCharArray();
            for (int i=0;i<str.length/2;i++){
                if (str[i]!=str[str.length-1-i])
                {return false;}
            }
            return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    //暴力解法
    /*public boolean checkPalindromeFormation(String a, String b) {
        if (isPalindrome(a) || isPalindrome(b)){
            return true;
        }
        int length = a.length();
        for (int i=0;i<length;i++){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a.substring(0,i+1));
            stringBuilder.append(b.substring(i+1));
            if (isPalindrome(stringBuilder.toString())){
                return true;
            }else{
                stringBuilder.delete(0,stringBuilder.length());
                stringBuilder.append(b.substring(0,i+1));
                stringBuilder.append(a.substring(i+1));
                if (isPalindrome(stringBuilder.toString())){
                    return true;
                }
            }
        }
        return false;
    }*/
}