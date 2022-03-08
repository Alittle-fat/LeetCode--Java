//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 深度优先搜索 动态规划 回溯算法 
// 👍 660 👎 0

package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：分割回文串
public class PalindromePartitioning{
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioning().new Solution();
        // TO TEST
        solution.partition("aa");
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
/*    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s.length()==1){
            List<String> temp = new ArrayList<>();
            temp.add(s);
            res.add(temp);
            return res;
        }
        for (int i=0;i<s.length();++i){
            String pre = s.substring(0,i+1);
            if (verf(pre)){
                if (i==s.length()-1){
                    List<String> tem = new ArrayList<>();
                    tem.add(pre);
                    res.add(tem);
                }else {
                    List<List<String>> nextList = partition(s.substring(i + 1));
                    for (List<String> list : nextList) {
                        list.add(pre);
                    }
                    res.addAll(nextList);
                }
            }
        }
        return res;
    }

    //验证某个字符串是否是回文字
    public boolean verf(String s){
        int size = s.length();
        if(size == 0 || size == 1){
            return true;
        }
        int l=0,r=size-1;
        while(l<=r){
            if (s.charAt(l++) != s.charAt(r--)){
                return false;
            }
        }
        return true;
    }*/
boolean[][] f;
        List<List<String>> ret = new ArrayList<List<String>>();
        List<String> ans = new ArrayList<String>();
        int n;

        public List<List<String>> partition(String s) {
            n = s.length();
            f = new boolean[n][n];
            for (int i = 0; i < n; ++i) {
                Arrays.fill(f[i], true);
            }

            for (int i = n - 1; i >= 0; --i) {
                for (int j = i + 1; j < n; ++j) {
                    f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
                }
            }

            dfs(s, 0);
            return ret;
        }

        public void dfs(String s, int i) {
            if (i == n) {
                ret.add(new ArrayList<String>(ans));
                return;
            }
            for (int j = i; j < n; ++j) {
                if (f[i][j]) {
                    ans.add(s.substring(i, j + 1));
                    dfs(s, j + 1);
                    ans.remove(ans.size() - 1);
                }
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}