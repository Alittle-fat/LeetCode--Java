//无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。 
//
// 示例1: 
//
// 
// 输入：S = "qwe"
// 输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
// 
//
// 示例2: 
//
// 
// 输入：S = "ab"
// 输出：["ab", "ba"]
// 
//
// 提示: 
//
// 
// 字符都是英文字母。 
// 字符串长度在[1, 9]之间。 
// 
// Related Topics 回溯算法 
// 👍 26 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Java：无重复字符串的排列组合
public class PermutationILcci{
    public static void main(String[] args) {
        Solution solution = new PermutationILcci().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
        //思路就是,从第一个位置开始,每个位置可用的字符个数是逐渐减少的,比如对于abcd来说,第一个位置可用a,b,c,d四个字符,
        // 第二个位置就只能用剩下的三个字符,以此类推
        public String[] permutation(String S) {
            char[] arrS = S.toCharArray();
            boolean[] used = new boolean[S.length()];
            LinkedList<String> result = new LinkedList<>();
            dfs(arrS, used, new StringBuilder(), result);
            return result.toArray(new String[0]);
        }

        private void dfs(char[] data, boolean[] used, StringBuilder stringBuilder, LinkedList<String> result) {
            if (stringBuilder.length() == data.length) {
                result.add(stringBuilder.toString());
                return;
            }
            for (int i = 0; i < data.length; i++) {
                if (used[i] == true) {
                    continue;
                }
                stringBuilder.append(data[i]);
                used[i] = true;
                dfs(data, used, stringBuilder, result);
                //删除操作,可借鉴
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                //当前层用完之前,将可用的状态恢复为原始状态
                used[i] = false;
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

    //交换位置的方法,不太容易理解,但是很简单
    char[] chars;
    List<String> res = new ArrayList<>();
    public String[] permutation(String S) {
        this.chars = S.toCharArray();
        def(0);
        return res.toArray(new String[(res.size())]);
    }

    private void def(int startPoint){
        if(startPoint == chars.length -1){
            res.add(String.valueOf(chars));
            return;
        }
        for(int i=startPoint;i<chars.length;i++){
            swap(startPoint,i);
            def(startPoint+1);
            swap(startPoint,i);
        }
    }

    private void swap(int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}