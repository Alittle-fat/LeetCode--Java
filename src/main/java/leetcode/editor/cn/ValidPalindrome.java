//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 283 👎 0

package leetcode.editor.cn;
//Java：验证回文串
public class ValidPalindrome{
    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0){
            return true;
        }
        char[] chars = s.toCharArray();
        int l = 0,r =chars.length-1;
        while(l<r){
            while(!Character.isLetterOrDigit(chars[l]) && l<r){
                ++l;
            }
            while(!Character.isLetterOrDigit(chars[r]) && l<r){
                --r;
            }
            if (Character.toLowerCase(chars[l]) == Character.toLowerCase(chars[r])){
                ++l;
                r--;
            }else{
                return false;
            }
        }
        return true;

        //正则,把特殊字符过滤掉，只留下字母和数字，然后转化为小写，再反转，最后在判断是否相等

        /*String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);*/


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}