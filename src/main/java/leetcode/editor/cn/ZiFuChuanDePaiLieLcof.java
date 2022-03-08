//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 回溯算法 
// 👍 365 👎 0

package leetcode.editor.cn;

import java.util.*;

//Java：字符串的排列
public class ZiFuChuanDePaiLieLcof{
    public static void main(String[] args) {
        Solution solution = new ZiFuChuanDePaiLieLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
        List<String> res;
        char[] c;
        public String[] permutation(String s) {
            res = new ArrayList<>();
            c = s.toCharArray();
            def(0);
            return res.toArray(new String[res.size()]);
        }
        void def(int x){
            //交换完了,将该种情况录入结果
            if (x == c.length-1){
                res.add(String.valueOf(c));
            }
            //去重,相同位置禁止放两次相同的值
            Set<Character> set = new HashSet<>();
            for(int i=x;i<c.length;++i){
                if (!set.contains(c[i])){
                    set.add(c[i]);
                    swap(x,i);
                    def(x+1);
                    swap(x,i);
                }
            }
        }
        void swap(int a, int b) {
            char tmp = c[a];
            c[a] = c[b];
            c[b] = tmp;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}