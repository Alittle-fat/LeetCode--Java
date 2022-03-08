//有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。 
//
// 示例1: 
//
//  输入：S = "qqe"
// 输出：["eqq","qeq","qqe"]
// 
//
// 示例2: 
//
//  输入：S = "ab"
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
import java.util.List;

//Java：有重复字符串的排列组合
public class PermutationIiLcci{
    public static void main(String[] args) {
        Solution solution = new PermutationIiLcci().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
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
            //temp 用于记录已经遍历过的字母,防止重复
            StringBuffer temp = new StringBuffer();
            for(int i=startPoint;i<chars.length;i++){
                if(-1 != temp.indexOf(String.valueOf(chars[i]))){
                    //相同字母已执行过,跳过
                    continue;
                }
                swap(startPoint,i);
                def(startPoint+1);
                swap(startPoint,i);
                //记录该字母
                temp.append(String.valueOf(chars[i]));
            }
            temp.setLength(0);
        }

        private void swap(int i, int j){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}