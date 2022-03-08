//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 3000 👎 0

package leetcode.editor.cn;
//Java：最长回文子串
public class LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        int n = s.length();
        boolean[][] isTrue = new boolean[n][n];
        for (int L =0;L < n;++L){
            for (int i=0;i+L<n;++i){
                int j = i+L;
                //边界条件
                if(L==0){
                    isTrue[i][j] = true;
                }else if(L == 1){
                    isTrue[i][j] = s.charAt(i) == s.charAt(j);
                }else{
                    //动态转移方程
                    isTrue[i][j] = s.charAt(i) == s.charAt(j) && isTrue[i+1][j-1];
                }
                //当前L下的循环到头,并且找到的子串长度大于最大值
                if(isTrue[i][j] && L+1> res.length()){
                    res = s.substring(i,j+1);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}