//实现 strStr() 函数。 
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。 
//
// 示例 1: 
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
// Related Topics 双指针 字符串 
// 👍 629 👎 0

package leetcode.editor.cn;
//Java：实现 strStr()
public class ImplementStrstr{
    public static void main(String[] args) {
        Solution solution = new ImplementStrstr().new Solution();
        // TO TEST
        int res = solution.strStr("mississippi","issip");
        System.out.println(res);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *这是双指针方法,也可以用移动窗口法
     */
    class Solution {
        public int strStr(String haystack, String needle) {
            int i=0,j=0;
            while((i<haystack.length())&&(j<needle.length())){
                if(haystack.charAt(i)==needle.charAt(j)){
                    ++i;
                    ++j;
                }else {
                    i=i-j+1;
                    j=0;
                }
            }
            if(j == needle.length()) {
                return i-j;
            }else{
                return -1;
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * 自己写的,有点繁琐
     */
    public int myStrStr(String haystack, String needle) {
        if (null == haystack){
            return -1;
        }
        if (null == needle || "" .equals(needle)){
            return 0;
        }
        char[] hChars = haystack.toCharArray();
        char[] nChars = needle.toCharArray();

        for (int i=0,j=0;i<hChars.length && j<hChars.length;){
            while(i<hChars.length && hChars[i] != nChars[j]){
                ++i;
            }
            if (i == hChars.length){
                return -1;
            }
            int fit = i;
            while(i<hChars.length && j<nChars.length && hChars[i] == nChars[j] ){
                ++i;
                ++j;
            }
            if(j == nChars.length){
                return i-j;
            }else{
                //本次没有找到,下次查找,i从之前匹配到的第一个值位置往后+1,j从头开始
                i = ++fit;
                j = 0;
            }
        }
        return -1;
    }
}